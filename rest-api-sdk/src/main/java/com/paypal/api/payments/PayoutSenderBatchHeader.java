package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PayoutSenderBatchHeader extends PayPalModel  {

	/**
	 * Sender-created ID for tracking the batch payout in an accounting system. 30 characters max.
	 */
	private String senderBatchId;

	/**
	 * The subject line text for the email that PayPal sends when a payout item is completed. (The subject line is the same for all recipients.) Maximum of 255 single-byte alphanumeric characters.
	 */
	private String emailSubject;

	/**
	 * The type of ID for a payment receiver. If this field is provided, the payout items without a `recipient_type` will use the provided value. If this field is not provided, each payout item must include a value for the `recipient_type`. 
	 */
	private String recipientType;

	/**
	 * Default Constructor
	 */
	public PayoutSenderBatchHeader() {
	}
}
