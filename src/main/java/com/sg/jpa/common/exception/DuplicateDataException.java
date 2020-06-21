package com.sg.jpa.common.exception;

public class DuplicateDataException extends AbstractException {

	private static final long serialVersionUID = -948336279121474463L;

	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return DUP_DATA_CODE;
	}
}
