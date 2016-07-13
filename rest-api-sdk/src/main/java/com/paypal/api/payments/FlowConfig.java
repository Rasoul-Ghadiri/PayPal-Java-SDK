package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class FlowConfig  extends PayPalModel {

	/**
	 * Type of PayPal page to be displayed when a user lands on the PayPal site for checkout. Allowed values: `Billing` or `Login`. When set to `Billing`, the Non-PayPal account landing page is used. When set to `Login`, the PayPal account login landing page is used.
	 */
	private String landingPageType;

	/**
	 * The URL on the merchant site for transferring to after a bank transfer payment. Use this field only if you are using giropay or bank transfer payment methods in Germany.
	 */
	private String bankTxnPendingUrl;

	/**
	 * Default Constructor
	 */
	public FlowConfig() {
	}
}
