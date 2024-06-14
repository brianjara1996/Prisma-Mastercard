package com.prismamp.api.coupons.mastercard.dto;

import java.math.BigDecimal;
import java.sql.Date;

import com.prismamp.api.coupons.mastercard.models.ECurrency;
import com.prismamp.api.coupons.mastercard.models.EFilterDate;
import com.prismamp.api.coupons.mastercard.models.EOrderBy;
import com.prismamp.api.coupons.mastercard.models.ETypeOrder;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GetCouponDTO {
	
	String cardNumber;
	Long accountNumber;
	String authorizationCode;
	String merchantName;
	String arn;
	BigDecimal amount;
	Long transactionReceipt;
	Long firstsix;
	Long lastfour;
	Date dateFrom;
	Date dateTo;
	ECurrency currency;
	EOrderBy orderBy;
	ETypeOrder typeOrder;
	EFilterDate filterDate;

}
