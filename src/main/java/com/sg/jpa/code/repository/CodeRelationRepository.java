package com.sg.jpa.code.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sg.jpa.code.model.CodeRelation;
import com.sg.jpa.code.model.RelationId;

@Repository
public interface CodeRelationRepository extends JpaRepository<CodeRelation, RelationId> {

	public void deleteByCode(String code);

	public long countByGroupCode(String groupCode);

	@Query(value = "select code from code_relation where group_code = ?1", nativeQuery = true)
	public List<String> findByGroupCode(String groupCode);
}
