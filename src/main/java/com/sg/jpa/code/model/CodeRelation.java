package com.sg.jpa.code.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import com.sg.jpa.common.model.AbstractModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@IdClass(RelationId.class)
@Entity(name = "CODE_RELATION")
public class CodeRelation extends AbstractModel {

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;*/

	@Id
	private String groupCode;

	@Id
	private String code;

	public CodeRelation(String groupCode, String code) {
		this.groupCode = groupCode;
		this.code = code;
	}
}
