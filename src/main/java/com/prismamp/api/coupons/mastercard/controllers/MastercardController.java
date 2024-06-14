package com.prismamp.api.coupons.mastercard.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prismamp.api.coupons.mastercard.config.ErrorResponse;
import com.prismamp.api.coupons.mastercard.config.ErrorResponse.ExceptionResponse;
import com.prismamp.api.coupons.mastercard.dto.GetCouponDTO;
import com.prismamp.api.coupons.mastercard.dto.GetMasterCardCouponsResponse;
import com.prismamp.api.coupons.mastercard.generic.Utils;
import com.prismamp.api.coupons.mastercard.services.MastercardCouponService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/mastercard")
public class MastercardController {
	
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private MastercardCouponService mastercardCouponService;
	
 
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public GetMasterCardCouponsResponse getCouponMC(@RequestParam Map<String, Object> allRequestParams) throws ExceptionResponse {
    	
    	GetCouponDTO findObject = new GetCouponDTO();
	    Utils.mapObject(findObject, allRequestParams, GetCouponDTO.class);
    	
    	return new 	GetMasterCardCouponsResponse(mastercardCouponService.getAll(findObject));
    }
    
    //Metodo para controlar todas la excepciones 
	@ExceptionHandler({ ExceptionResponse.class })
	public ResponseEntity<ErrorResponse> handleException(ExceptionResponse e) {
		return ResponseEntity.status(e.getError().getStatus()).body(new ErrorResponse(e, request));
	}
}
