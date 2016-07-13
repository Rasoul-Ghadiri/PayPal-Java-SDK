package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RelatedResources  extends PayPalModel {

	/**
	 * A sale transaction
	 */
	private Sale sale;

	/**
	 * An order transaction
	 */
	private Authorization authorization;

	/**
	 * A capture transaction
	 */
	private Capture capture;

	/**
	 * A refund transaction
	 */
	private Refund refund;
	
	/**
	 * An order transaction
	 */
	private Order order;

	/**
	 * Default Constructor
	 */
	public RelatedResources() {
	}
}
