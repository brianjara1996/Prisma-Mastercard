package com.prismamp.api.coupons.mastercard.models;


import lombok.Getter;

@Getter
public enum ECurrency {
	
	ARS("ARS"), USD("USD");

	private String name;

	ECurrency(String name) {
		this.name = name;
	}


}
