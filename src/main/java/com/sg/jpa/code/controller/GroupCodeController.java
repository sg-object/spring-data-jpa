package com.sg.jpa.code.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sg.jpa.code.model.Code;
import com.sg.jpa.code.model.GroupCode;
import com.sg.jpa.code.service.GroupCodeService;

@RestController
@RequestMapping("/groups")
public class GroupCodeController {

	@Autowired
	private GroupCodeService groupCodeService;

	@GetMapping
	public List<GroupCode> getGroupCodeList(int page, int size) {
		return groupCodeService.getGroupCodeList(page, size);
	}

	@GetMapping("/{groupCode}")
	public GroupCode getGroupCode(@PathVariable String groupCode) {
		return groupCodeService.getGroupCode(groupCode);
	}

	@GetMapping("/{groupCode}/codes")
	public List<Code> getCodeListOfGroup(@PathVariable String groupCode) {
		return groupCodeService.getCodeListOfGroup(groupCode);
	}

	@PostMapping
	public void createGroupCode(@RequestBody GroupCode groupCode) {
		groupCodeService.createGroupCode(groupCode);
	}

	@PutMapping("/{groupCode}")
	public void updateGroupCode(@PathVariable String groupCode, @RequestBody GroupCode body) {
		body.setGroupCode(groupCode);
		groupCodeService.updateGroupCode(body);
	}

	@DeleteMapping("/{groupCode}")
	public void deleteGroupCode(@PathVariable String groupCode) {
		groupCodeService.deleteGroupCode(groupCode);
	}
}
