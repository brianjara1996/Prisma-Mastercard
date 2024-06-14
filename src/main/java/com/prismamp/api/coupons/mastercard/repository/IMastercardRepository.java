package com.prismamp.api.coupons.mastercard.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.prismamp.api.coupons.mastercard.models.CouponMastercard;

public interface IMastercardRepository extends CrudRepository<CouponMastercard, Long> {
	
	// Select a la Tabla tx_master filtrando por nro de cuenta o nro de tarjeta del cliente
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	@Query(value = "SELECT TOP (1000) * FROM tx_master C WHERE"
			+ " (:accountNumber IS NULL OR C.account_number = :accountNumber)"
			+ " AND (:cardNumber IS NULL OR C.card_number = :cardNumber)"
			+ " AND (:authorizationCode IS NULL OR C.authorization_code = :authorizationCode)"
			+ " AND (:merchantName IS NULL OR C.merchant_name = :merchantName)"
			+ " AND (:arn IS NULL OR C.arn = :arn)" 
			
			+ " AND (:amount IS NULL OR C.amount = :amount)"
			+ " AND (:amount IS NULL OR C.amount_usd = :amount)"
			+ " AND (:currency IS NULL OR C.currency = :currency)" 
			+ " AND (:firstsix IS NULL OR C.first_six = :firstsix)"
			+ " AND (:lastfour IS NULL OR C.last_four = :lastfour)" 
			+ " AND (:transactionreceipt IS NULL OR C.transaction_receipt = :transactionreceipt)" 

			+" AND (:purchaseDateFrom IS NULL OR C.purchase_date <= :purchaseDateFrom)"
			+ " AND (:purchaseDateTo IS NULL OR C.purchase_date >= :purchaseDateTo)" +

			" AND (:processingDateFrom IS NULL OR C.processing_date <= :processingDateFrom)"
			+ " AND (:processingDateTo IS NULL OR C.processing_date >= :processingDateTo)"
            , nativeQuery = true)
	List<CouponMastercard> FindCoupon(
			@Param("accountNumber") Long accountNumber, 
			@Param("cardNumber") String cardNumber,
			@Param("authorizationCode") String authorizationCode, 
			@Param("merchantName") String merchantName,
			@Param("arn") String arn,
			@Param("amount") BigDecimal amount,
			@Param("currency") String currency, 
			@Param("firstsix") Long firstsix, 
			@Param("lastfour") Long lastfour, 
			@Param("transactionreceipt") Long transactionreceipt, 
			@Param("purchaseDateFrom") Date purchaseDateFrom,
			@Param("purchaseDateTo") Date purchaseDateTo, 
			@Param("processingDateFrom") Date processingDateFrom,
			@Param("processingDateTo") Date processingDateTo
			);
}
