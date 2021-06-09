package com.yildiz.hrms.core.utilities.result;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data) {
		super(data,true);
	}
	
	public SuccessDataResult(String message, T data) {
		super(data,true, message);
	}

}
