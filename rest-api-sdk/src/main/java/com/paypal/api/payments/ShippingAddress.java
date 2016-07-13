package com.paypal.api.payments;


import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ShippingAddress extends Address {

	/**
	 * Address ID assigned in PayPal system.
	 */
	private String id;

	/**
	 * Name of the recipient at this address.
	 */
	private String recipientName;

	/**
	 * Default shipping address of the Payer.
	 */
	private Boolean defaultAddress;

	/**
	 * Default Constructor
	 */
	public ShippingAddress() {
	}

	/**
	 * Parameterized Constructor
	 */
	public ShippingAddress(String recipientName) {
		this.recipientName = recipientName;
	}
}
