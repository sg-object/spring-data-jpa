package com.sg.jpa.code.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Data;

@DynamicUpdate
@Data
@Entity(name = "CODE")
public class Code {

	private String groupCode;

	@Id
	private String code;

	private String codeName;
}
