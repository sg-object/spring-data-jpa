package com.sg.jpa.code.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sg.jpa.code.model.Code;
import com.sg.jpa.code.model.CodeRelation;
import com.sg.jpa.code.repository.CodeRepository;
import com.sg.jpa.common.exception.DuplicateDataException;
import com.sg.jpa.common.exception.NotFoundDataException;
import com.sg.jpa.common.exception.VerificationException;
import com.sg.jpa.common.util.PageRequestUtils;
import com.sg.jpa.common.util.VerificationUtils;

@Service
public class CodeService {

	@Autowired
	private CodeRepository codeRepository;

	@Autowired
	private CodeRelationService codeRelationService;

	@Autowired
	private GroupCodeService groupCodeService;

	public List<Code> getCodeList(int page, int size) {
		if (!VerificationUtils.checkPageValue(page, size)) {
			throw new VerificationException();
		}
		return codeRepository.findAll(PageRequestUtils.getRequest(page, size, Sort.by("code").descending()))
				.getContent();
	}

	public Code getCode(String code) {
		checkStringValue(code);
		Code result = codeRepository.findByCode(code);
		if (result == null) {
			throw new NotFoundDataException();
		}
		return result;
	}

	public List<Code> getCodeList(List<String> codes) {
		return codeRepository.findAllById(codes);
	}

	@Transactional
	public void createCode(Code code) {
		checkStringValue(code.getCode());
		checkStringValue(code.getGroupCode());

		Code data = codeRepository.findByCode(code.getCode());
		if (data != null) {
			throw new DuplicateDataException();
		}
		groupCodeService.getGroupCode(code.getGroupCode());
		codeRepository.save(code);

		codeRelationService.createRelation(new CodeRelation(code.getGroupCode(), code.getCode()));
	}

	@Transactional
	public void updateCode(Code code) {
		Code data = getCode(code.getCode());
		data.setCodeName(code.getCodeName());
	}

	@Transactional
	public void deleteCode(String code) {
		getCode(code);
		codeRepository.deleteByCode(code);
		codeRelationService.deleteRelationByCode(code);
	}

	private void checkStringValue(String value) {
		if (VerificationUtils.isNullOrBlank(value)) {
			throw new VerificationException();
		}
	}
}
