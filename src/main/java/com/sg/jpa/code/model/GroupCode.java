package com.sg.jpa.code.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.DynamicUpdate;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@DynamicUpdate
@Data
@Entity(name = "GROUP_CODE")
public class GroupCode {

	@Id
	private String groupCode;

	private String groupName;

	@ApiModelProperty(hidden = true)
	@OneToMany
	@JoinColumn(name = "groupCode")
	private List<Code> codes;
}
