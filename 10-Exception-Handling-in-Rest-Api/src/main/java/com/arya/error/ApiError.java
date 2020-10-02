package com.arya.error;

import lombok.Data;

@Data
public class ApiError {
	
	Integer statuseCode;
	String Discription;
	 
	public ApiError(Integer statuseCode, String discription) {
		this.statuseCode = statuseCode;
		Discription = discription;
	}

}
