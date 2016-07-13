package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Error extends PayPalModel {

	/**
	 * Human readable, unique name of the error.
	 */
	private String name;

	/**
	 * Reference ID of the purchase_unit associated with this error
	 */
	private String purchaseUnitReferenceId;

	/**
	 * Message describing the error.
	 */
	private String message;

	/**
	 * PayPal internal error code.
	 */
	private String code;

	/**
	 * Additional details of the error
	 */
	private List<ErrorDetails> details;

	/**
	 * response codes returned from a payment processor such as avs, cvv, etc. Only supported when the `payment_method` is set to `credit_card`.
	 */
	private ProcessorResponse processorResponse;

	/**
	 * Fraud filter details.  Only supported when the `payment_method` is set to `credit_card`
	 */
	private FmfDetails fmfDetails;

	/**
	 * URI for detailed information related to this error for the developer.
	 */
	private String informationLink;

	/**
	 * PayPal internal identifier used for correlation purposes.
	 */
	private String debugId;

	/**
	 * Links
	 */
	private List<DefinitionsLinkdescription> links;

	/**
	 * Default Constructor
	 */
	public Error() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Error(String name, String message, String informationLink, String debugId) {
		this.name = name;
		this.message = message;
		this.informationLink = informationLink;
		this.debugId = debugId;
	}

	public String toString() {
		return "name: " + this.name + "\tmessage: " + this.message + "\tdetails: " + this.details + "\tdebug-id: " + this.debugId + "\tinformation-link: " + this.informationLink;
	}

}
