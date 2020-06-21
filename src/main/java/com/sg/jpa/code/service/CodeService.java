package com.sg.jpa.code.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sg.jpa.code.model.Code;
import com.sg.jpa.code.model.GroupCode;
import com.sg.jpa.code.repository.CodeRepository;
import com.sg.jpa.code.repository.GroupCodeRepository;
import com.sg.jpa.common.exception.DuplicateDataException;
import com.sg.jpa.common.exception.NotFoundDataException;
import com.sg.jpa.common.exception.VerificationException;
import com.sg.jpa.common.util.PageRequestUtils;
import com.sg.jpa.common.util.VerificationUtils;

@Service
public class CodeService {

	@Autowired
	private GroupCodeRepository groupCodeRepository;

	@Autowired
	private CodeRepository codeRepository;

	public List<Code> getCodeList(int page, int size) {
		if (!VerificationUtils.checkPageValue(page, size)) {
			throw new VerificationException();
		}
		return codeRepository.findAll(PageRequestUtils.getRequest(page, size, Sort.by("groupCode").descending()))
				.getContent();
	}

	public Code getCode(String code) {
		if (VerificationUtils.isNullOrBlank(code)) {
			throw new VerificationException();
		}
		Code result = codeRepository.findByCode(code);
		if (result == null) {
			throw new NotFoundDataException();
		}
		return result;
	}

	@Transactional
	public void createCode(Code code) {
		if (VerificationUtils.isNullOrBlank(code.getCode()) || VerificationUtils.isNullOrBlank(code.getGroupCode())) {
			throw new VerificationException();
		}
		Code codeData = codeRepository.findByCode(code.getCode());
		GroupCode groupData = groupCodeRepository.findByGroupCode(code.getGroupCode());
		if (codeData != null) {
			throw new DuplicateDataException();
		}
		if (groupData == null) {
			throw new NotFoundDataException();
		}
		codeRepository.save(code);
	}

	@Transactional
	public void updateCode(Code code) {
		if (VerificationUtils.isNullOrBlank(code.getCode())) {
			throw new VerificationException();
		}
		Code data = getCode(code.getCode());
		data.setCodeName(code.getCodeName());
	}

	@Transactional
	public void deleteCode(String code) {
		if (VerificationUtils.isNullOrBlank(code)) {
			throw new VerificationException();
		}
		getCode(code);
		codeRepository.deleteByCode(code);
	}
}
