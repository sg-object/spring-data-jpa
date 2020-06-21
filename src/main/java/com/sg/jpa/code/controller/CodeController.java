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
import com.sg.jpa.code.service.CodeService;

@RestController
@RequestMapping("/codes")
public class CodeController {

	@Autowired
	private CodeService codeService;

	@GetMapping
	public List<Code> getCodeList(int page, int size) {
		return codeService.getCodeList(page, size);
	}

	@GetMapping("/{code}")
	public Code getCode(@PathVariable String code) {
		return codeService.getCode(code);
	}

	@PostMapping
	public void createCode(@RequestBody Code code) {
		codeService.createCode(code);
	}

	@PutMapping("/{code}")
	public void updateCode(@PathVariable String code, @RequestBody Code body) {
		body.setCode(code);
		codeService.updateCode(body);
	}

	@DeleteMapping("/{code}")
	public void deleteCode(@PathVariable String code) {
		codeService.deleteCode(code);
	}
}
