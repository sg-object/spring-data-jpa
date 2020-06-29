package com.sg.jpa.code.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sg.jpa.code.model.Code;
import com.sg.jpa.code.model.CodeRelation;
import com.sg.jpa.code.repository.CodeRelationRepository;

@Service
public class CodeRelationService {

	@Autowired
	private CodeRelationRepository codeRelationRepository;

	@Autowired
	private CodeService codeService;

	@Transactional
	public void createRelation(CodeRelation codeRelation) {
		codeRelationRepository.save(codeRelation);
	}

	@Transactional
	public void deleteRelationByCode(String code) {
		codeRelationRepository.deleteByCode(code);
	}

	public long countCodeOfGroup(String groupCode) {
		return codeRelationRepository.countByGroupCode(groupCode);
	}

	public List<Code> getCodeListOfGroup(String groupCode) {
		return codeService.getCodeList(codeRelationRepository.findByGroupCode(groupCode));
	}
}
