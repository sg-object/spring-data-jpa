package com.sg.jpa.common.model;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@MappedSuperclass
public class AbstractModel {

	@ApiModelProperty(hidden = true)
	@CreationTimestamp
	private LocalDateTime createDate;
}
