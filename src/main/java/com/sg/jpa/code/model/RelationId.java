package com.sg.jpa.code.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class RelationId implements Serializable {

	private static final long serialVersionUID = 6323107864716913766L;

	private String groupCode;

	private String code;
}
