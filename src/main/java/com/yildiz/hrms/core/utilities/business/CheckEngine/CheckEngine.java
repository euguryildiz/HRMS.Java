package com.yildiz.hrms.core.utilities.business.CheckEngine;

import com.yildiz.hrms.core.utilities.result.Result;
import com.yildiz.hrms.core.utilities.result.SuccessResult;

public class CheckEngine {
	
	public static Result run(Result... rules) {
		
		for (Result rule : rules) {
			if(!rule.isSuccess()) {
				return rule;
			}
		}
		
		return new SuccessResult();
	}
}