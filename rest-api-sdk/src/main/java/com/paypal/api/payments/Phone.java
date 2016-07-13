package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Phone extends PayPalModel {

	/**
	 * The country calling code (CC) as defined by E.164. The combined length of CC+national cannot be more than 15 digits. 
	 */
	private String countryCode;

	/**
	 * The national number as defined by E.164. The combined length of CC+national cannot be more than 15 digits. A national number consists of National Destination Code (NDC) and Subscriber Number (SN).
	 */
	private String nationalNumber;

	/**
	 * Phone extension
	 */
	private String extension;

	/**
	 * Default Constructor
	 */
	public Phone() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Phone(String countryCode, String nationalNumber) {
		this.countryCode = countryCode;
		this.nationalNumber = nationalNumber;
	}
}
