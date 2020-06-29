package com.sg.jpa.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sg.jpa.code.model.Code;

@Repository
public interface CodeRepository extends JpaRepository<Code, String> {

	public Code findByCode(String code);

	public void deleteByCode(String code);
}
