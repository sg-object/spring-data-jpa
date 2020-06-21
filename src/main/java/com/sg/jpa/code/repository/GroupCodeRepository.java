package com.sg.jpa.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sg.jpa.code.model.GroupCode;

@Repository
public interface GroupCodeRepository extends JpaRepository<GroupCode, Long> {

	public GroupCode findByGroupCode(String groupCode);

	public void deleteByGroupCode(String groupCode);
}
