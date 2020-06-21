package com.sg.jpa.common.exception;

public class UsingDataException extends AbstractException {

	private static final long serialVersionUID = -7507293843192822446L;

	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return USING_DATA_CODE;
	}
}
