package com.paypal.api.payments;

import com.paypal.base.rest.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PayoutItem extends PayPalResource {

	/**
	 * The type of identification for the payment receiver. If this field is
	 * provided, the payout items without a `recipient_type` will use the
	 * provided value. If this field is not provided, each payout item must
	 * include a value for the `recipient_type`.
	 */
	private String recipientType;

	/**
	 * The amount of money to pay a receiver.
	 */
	private Currency amount;

	/**
	 * Note for notifications. The note is provided by the payment sender. This
	 * note can be any string. 4000 characters max.
	 */
	private String note;

	/**
	 * The receiver of the payment. In a call response, the format of this value
	 * corresponds to the `recipient_type` specified in the request. 127
	 * characters max.
	 */
	private String receiver;

	/**
	 * A sender-specific ID number, used in an accounting system for tracking
	 * purposes. 30 characters max.
	 */
	private String senderItemId;
	
	/**
	 * Default Constructor
	 */
	public PayoutItem() {
	}

	/**
	 * Parameterized Constructor
	 */
	public PayoutItem(Currency amount, String receiver) {
		this.amount = amount;
		this.receiver = receiver;
	}

	/**
	 * Obtain the status of a payout item by passing the item ID to the request
	 * URI.
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 * 
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param payoutItemId
	 *            String
	 * @return PayoutItemDetails
	 * @throws PayPalRESTException
	 */
	public static PayoutItemDetails get(String accessToken, String payoutItemId)
			throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, payoutItemId);
	}

	/**
	 * Obtain the status of a payout item by passing the item ID to the request
	 * URI.
	 * 
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param payoutItemId
	 *            String
	 * @return PayoutItemDetails
	 * @throws PayPalRESTException
	 */
	public static PayoutItemDetails get(APIContext apiContext,
			String payoutItemId) throws PayPalRESTException {
		if (payoutItemId == null) {
			throw new IllegalArgumentException("payoutItemId cannot be null");
		}
		Object[] parameters = new Object[] { payoutItemId };
		String pattern = "v1/payments/payouts-item/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET,
				resourcePath, payLoad, PayoutItemDetails.class);
	}

	/**
	 * Cancels the unclaimed payment using the items id passed in the request
	 * URI. If an unclaimed item is not claimed within 30 days, the funds will
	 * be automatically returned to the sender. This call can be used to cancel
	 * the unclaimed item prior to the automatic 30-day return.
	 * @deprecated Please use {@link #cancel(APIContext, String)} instead.
	 * 
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param payoutItemId
	 *            String
	 * @return PayoutItemDetails
	 * @throws PayPalRESTException
	 */
	public static PayoutItemDetails cancel(String accessToken,
			String payoutItemId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return cancel(apiContext, payoutItemId);
	}

	/**
	 * Cancels the unclaimed payment using the items id passed in the request
	 * URI. If an unclaimed item is not claimed within 30 days, the funds will
	 * be automatically returned to the sender. This call can be used to cancel
	 * the unclaimed item prior to the automatic 30-day return.
	 * 
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param payoutItemId
	 *            String
	 * @return PayoutItemDetails
	 * @throws PayPalRESTException
	 */
	public static PayoutItemDetails cancel(APIContext apiContext,
			String payoutItemId) throws PayPalRESTException {
		if (payoutItemId == null) {
			throw new IllegalArgumentException("payoutItemId cannot be null");
		}
		Object[] parameters = new Object[] { payoutItemId };
		String pattern = "v1/payments/payouts-item/{0}/cancel";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.POST,
				resourcePath, payLoad, PayoutItemDetails.class);
	}
	
}
