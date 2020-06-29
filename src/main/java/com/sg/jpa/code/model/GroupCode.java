package com.sg.jpa.code.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.hibernate.annotations.DynamicUpdate;
import com.sg.jpa.common.model.AbstractModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@DynamicUpdate
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "GROUP_CODE")
public class GroupCode extends AbstractModel {

	@Id
	private String groupCode;

	private String groupName;

	@ApiModelProperty(hidden = true)
	@Transient
	private List<String> codes;
}
