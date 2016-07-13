package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CartBase  extends PayPalModel {

	/**
	 * Merchant identifier to the purchase unit. Optional parameter
	 */
	private String referenceId;

	/**
	 * Amount being collected.
	 */
	private Amount amount;

	/**
	 * Recipient of the funds in this transaction.
	 */
	private Payee payee;

	/**
	 * Description of transaction.
	 */
	private String description;

	/**
	 * Note to the recipient of the funds in this transaction.
	 */
	private String noteToPayee;

	/**
	 * Free-form field for the use of clients. Only supported when the `payment_method` is set to `paypal`.
	 */
	private String custom;

	/**
	 * Invoice number used to track the payment. Only supported when the `payment_method` is set to `paypal`.
	 */
	private String invoiceNumber;

	/**
	 * Soft descriptor used when charging this funding source. If length exceeds max length, the value will be truncated
	 */
	private String softDescriptor;

	/**
	 * Soft descriptor city used when charging this funding source. If length exceeds max length, the value will be truncated. Only supported when the `payment_method` is set to `credit_card`
	 */
	private String softDescriptorCity;

	/**
	 * Payment options requested for this purchase unit
	 */
	private PaymentOptions paymentOptions;

	/**
	 * Items and related shipping address within a transaction.
	 */
	private ItemList itemList;

	/**
	 * URL to send payment notifications
	 */
	private String notifyUrl;

	/**
	 * Url on merchant site pertaining to this payment.
	 */
	private String orderUrl;

	/**
	 * List of external funding being applied to the purchase unit. Each external_funding unit should have a unique reference_id
	 */
	private List<ExternalFunding> externalFunding;

	/**
	 * Default Constructor
	 */
	public CartBase() {
	}

	/**
	 * Parameterized Constructor
	 */
	public CartBase(Amount amount) {
		this.amount = amount;
	}
}
