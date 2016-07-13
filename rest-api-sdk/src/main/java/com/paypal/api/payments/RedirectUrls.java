package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RedirectUrls  extends PayPalModel {

	/**
	 * Url where the payer would be redirected to after approving the payment.
	 */
	private String returnUrl;

	/**
	 * Url where the payer would be redirected to after canceling the payment.
	 */
	private String cancelUrl;

	/**
	 * Default Constructor
	 */
	public RedirectUrls() {
	}
}
