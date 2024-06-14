package com.prismamp.api.coupons.mastercard.dto;

import java.util.List;

import com.prismamp.api.coupons.mastercard.models.CouponMastercard;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetMasterCardCouponsResponse {
	
	List<CouponMastercard> coupons;

}
