package com.prismamp.api.coupons.mastercard.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tx_master")
@NoArgsConstructor
@Getter
@Setter
public class CouponMastercard {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "account_number")
	private Integer account_number;

	@Column(name = "card_number")
	private String card_number;

	@Column(name = "arn")
	private String arn;

	@Column(name = "purchase_date")
	private Date purchase_date;

	@Column(name = "currency")
	private String currency;

	@Column(name = "amount")
	private Float amount;

	@Column(name = "amount_usd")
	private Float amount_usd;

	@Column(name = "merchant_name")
	private String merchant_name;

	@Column(name = "merchant_city")
	private String merchant_city;

	@Column(name = "merchant_country")
	private String merchant_country;

	@Column(name = "merchant_province")
	private String merchant_province;

	@Column(name = "merchant_category_code")
	private Integer merchant_category_code;

	@Column(name = "issuer_bank_code")
	private Integer issuer_bank_code;

	@Column(name = "issuer_branch_code")
	private Integer issuer_branch_code;

	@Column(name = "bill_cycle")
	private Integer bill_cycle;

	@Column(name = "payment_date")
	private Date payment_date;

	@Column(name = "authorization_code")
	private String authorization_code;

	@Column(name = "plan_type")
	private String plan_type;

	@Column(name = "total_instalments")
	private Integer total_instalments;

	@Column(name = "instalment_number")
	private Integer instalment_number;

	@Column(name = "moto_eci")
	private String moto_eci;

	@Column(name = "pos_terminal_capabilitiy")
	private String pos_terminal_capabilitiy;

	@Column(name = "pos_entry_mode")
	private String pos_entry_mode;

	@Column(name = "card_product")
	private String card_product;

	@Column(name = "card_type")
	private String card_type;

	@Column(name = "transaction_code")
	private String transaction_code;

	@Column(name = "merchant_number")
	private String merchant_number;

	@Column(name = "processing_date")
	private Date processing_date;

	@Column(name = "cie_number")
	private String cie_number;

	@Column(name = "transaction_mark")
	private String transaction_mark;

	@Column(name = "aut_debit_indicator")
	private String aut_debit_indicator;

	@Column(name = "merchant_discount_percentage")
	private Float merchant_discount_percentage;

	@Column(name = "user_discount_percentage")
	private Float user_discount_percentage;

	@Column(name = "clean_sumary_indicator")
	private String clean_sumary_indicator;

	@Column(name = "pos_environment")
	private String pos_environment;

	@Column(name = "automatic_debit_client_id")
	private String automatic_debit_client_id;

	@Column(name = "financial_indicator")
	private String financial_indicator;

	@Column(name = "dcc_indicator")
	private String dcc_indicator;

	@Column(name = "invoice_period")
	private String invoice_period;

	@Column(name = "wallet_id")
	private String wallet_id;

	@Column(name = "transaction_id")
	private String transaction_id;

	@Column(name = "instalment_type")
	private String instalment_type;

	@Column(name = "total_amount")
	private Float total_amount;

	@Column(name = "instalment_interest")
	private Float instalment_Integererest;

	@Column(name = "vat_interest_amount")
	private Float vat_Integererest_amount;
	
	@Column(name = "transaction_receipt")
	private Integer transaction_receipt;
	
	@Column(name = "first_six")
	private Integer first_six;
	
	@Column(name = "last_four")
	private Integer last_four;

}
