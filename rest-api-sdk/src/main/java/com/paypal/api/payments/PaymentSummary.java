package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PaymentSummary extends PayPalModel {

	/**
	 * Total Amount paid/refunded via PayPal.
	 */
	private Currency paypal;

	/**
	 * Total Amount paid/refunded via other sources.
	 */
	private Currency other;

	/**
	 * Default Constructor
	 */
	public PaymentSummary() {
	}

}
