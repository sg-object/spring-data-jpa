package com.sg.jpa.code.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sg.jpa.code.model.Code;
import com.sg.jpa.code.model.GroupCode;
import com.sg.jpa.code.repository.GroupCodeRepository;
import com.sg.jpa.common.exception.DuplicateDataException;
import com.sg.jpa.common.exception.NotFoundDataException;
import com.sg.jpa.common.exception.UsingDataException;
import com.sg.jpa.common.exception.VerificationException;
import com.sg.jpa.common.util.PageRequestUtils;
import com.sg.jpa.common.util.VerificationUtils;

@Service
public class GroupCodeService {

	@Autowired
	private GroupCodeRepository groupCodeRepository;

	@Autowired
	private CodeRelationService codeRelationService;

	public List<GroupCode> getGroupCodeList(int page, int size) {
		if (!VerificationUtils.checkPageValue(page, size)) {
			throw new VerificationException();
		}
		return groupCodeRepository.findAll(PageRequestUtils.getRequest(page, size, Sort.by("groupCode").descending()))
				.getContent();
	}

	public GroupCode getGroupCode(String groupCode) {
		checkStringValue(groupCode);
		GroupCode result = groupCodeRepository.findByGroupCode(groupCode);
		if (result == null) {
			throw new NotFoundDataException();
		}
		return result;
	}

	public List<Code> getCodeListOfGroup(String groupCode) {
		checkStringValue(groupCode);
		return codeRelationService.getCodeListOfGroup(groupCode);
	}

	@Transactional
	public void createGroupCode(GroupCode groupCode) {
		checkStringValue(groupCode.getGroupCode());
		checkStringValue(groupCode.getGroupName());
		GroupCode data = groupCodeRepository.findByGroupCode(groupCode.getGroupCode());
		if (data != null) {
			throw new DuplicateDataException();
		}
		groupCodeRepository.save(groupCode);
	}

	@Transactional
	public void updateGroupCode(GroupCode groupCode) {
		GroupCode data = getGroupCode(groupCode.getGroupCode());
		data.setGroupName(groupCode.getGroupName());
	}

	@Transactional
	public void deleteGroupCode(String groupCode) {
		getGroupCode(groupCode);
		if (codeRelationService.countCodeOfGroup(groupCode) > 0) {
			throw new UsingDataException();
		}
		groupCodeRepository.deleteByGroupCode(groupCode);
	}

	private void checkStringValue(String value) {
		if (VerificationUtils.isNullOrBlank(value)) {
			throw new VerificationException();
		}
	}
}
