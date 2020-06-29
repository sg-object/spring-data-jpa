package com.sg.jpa.code.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.hibernate.annotations.DynamicUpdate;
import com.sg.jpa.common.model.AbstractModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@DynamicUpdate
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "CODE")
public class Code extends AbstractModel {

	@Id
	private String code;

	private String codeName;

	@Transient
	private String groupCode;
}
