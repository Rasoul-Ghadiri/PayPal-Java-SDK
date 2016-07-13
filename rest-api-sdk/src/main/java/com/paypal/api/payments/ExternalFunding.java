package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ExternalFunding extends PayPalModel {

	/**
	 * Unique identifier for the external funding
	 */
	private String referenceId;

	/**
	 * Generic identifier for the external funding
	 */
	private String code;

	/**
	 * Encrypted PayPal Account identifier for the funding account
	 */
	private String fundingAccountId;

	/**
	 * Description of the external funding being applied
	 */
	private String displayText;

	/**
	 * Amount being funded by the external funding account
	 */
	private Amount amount;

	/**
	 * Default Constructor
	 */
	public ExternalFunding() {
	}

	/**
	 * Parameterized Constructor
	 */
	public ExternalFunding(String referenceId, String fundingAccountId, Amount amount) {
		this.referenceId = referenceId;
		this.fundingAccountId = fundingAccountId;
		this.amount = amount;
	}
}
