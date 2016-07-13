package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PaymentOptions  extends PayPalModel {

	/**
	 * Optional payment method type. If specified, the transaction will go through for only instant payment. Only for use with the paypal payment_method, not relevant for the credit_card payment_method.
	 */
	private String allowedPaymentMethod;

	/**
	 * Indicator if this payment request is a recurring payment. Only supported when the `payment_method` is set to `credit_card`
	 */
	private Boolean recurringFlag;

	/**
	 * Indicator if fraud management filters (fmf) should be skipped for this transaction. Only supported when the `payment_method` is set to `credit_card`
	 */
	private Boolean skipFmf;

	/**
	 * Default Constructor
	 */
	public PaymentOptions() {
	}
}
