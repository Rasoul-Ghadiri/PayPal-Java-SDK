package com.paypal.api.payments;

import com.paypal.base.rest.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Order  extends PayPalResource {

	/**
	 * Identifier of the order transaction.
	 */
	private String id;

	/**
	 * Identifier to the purchase unit associated with this object. Obsolete. Use one in cart_base.
	 */
	private String purchaseUnitReferenceId;

	/**
	 * Amount being collected.
	 */
	private Amount amount;

	/**
	 * specifies payment mode of the transaction
	 */
	private String paymentMode;

	/**
	 * State of the order transaction.
	 */
	private String state;

	/**
	 * Reason code for the transaction state being Pending or Reversed. Only supported when the `payment_method` is set to `paypal`.
	 */
	private String reasonCode;

	/**
	 * [DEPRECATED] Reason the transaction is in pending state. Use reason_code field above instead. 
	 */
	private String pendingReason;

	/**
	 * The level of seller protection in force for the transaction.
	 */
	private String protectionEligibility;

	/**
	 * The kind of seller protection in force for the transaction. This property is returned only when the `protection_eligibility` property is set to `ELIGIBLE`or `PARTIALLY_ELIGIBLE`. Only supported when the `payment_method` is set to `paypal`. Allowed values:<br> `ITEM_NOT_RECEIVED_ELIGIBLE`- Sellers are protected against claims for items not received.<br> `UNAUTHORIZED_PAYMENT_ELIGIBLE`- Sellers are protected against claims for unauthorized payments.<br> One or both of the allowed values can be returned.
	 */
	private String protectionEligibilityType;

	/**
	 * ID of the Payment resource that this transaction is based on.
	 */
	private String parentPayment;

	/**
	 * Fraud Management Filter (FMF) details applied for the payment that could result in accept/deny/pending action.
	 */
	private FmfDetails fmfDetails;

	/**
	 * Time the resource was created in UTC ISO8601 format.
	 */
	private String createTime;

	/**
	 * Time the resource was last updated in UTC ISO8601 format.
	 */
	private String updateTime;

	/**
	 * 
	 */
	private List<Links> links;
	
	/**
	 * Default Constructor
	 */
	public Order() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Order(Amount amount) {
		this.amount = amount;
	}
	
	/**
	 * Obtain the Order resource for the given identifier.
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param orderId
	 *            String
	 * @return Order
	 * @throws PayPalRESTException
	 */
	public static Order get(String accessToken, String orderId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, orderId);
	}

	/**
	 * Obtain the Order resource for the given identifier.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param orderId
	 *            String
	 * @return Order
	 * @throws PayPalRESTException
	 */
	public static Order get(APIContext apiContext, String orderId) throws PayPalRESTException {

		if (orderId == null) {
			throw new IllegalArgumentException("orderId cannot be null");
		}
		Object[] parameters = new Object[] {orderId};
		String pattern = "v1/payments/orders/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Order.class);
	}


	/**
	 * Creates (and processes) a new Capture Transaction added as a related resource.
	 * @deprecated Please use {@link #capture(APIContext, Capture)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param capture
	 *            Capture
	 * @return Capture
	 * @throws PayPalRESTException
	 */
	public Capture capture(String accessToken, Capture capture) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return capture(apiContext, capture);
	}

	/**
	 * Creates (and processes) a new Capture Transaction added as a related resource.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param capture
	 *            Capture
	 * @return Capture
	 * @throws PayPalRESTException
	 */
	public Capture capture(APIContext apiContext, Capture capture) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (capture == null) {
			throw new IllegalArgumentException("capture cannot be null");
		}
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "v1/payments/orders/{0}/capture";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = capture.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Capture.class);
	}


	/**
	 * Voids (cancels) an Order.
	 * @deprecated Please use {@link #doVoid(APIContext)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @return Order
	 * @throws PayPalRESTException
	 */
	public Order doVoid(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return doVoid(apiContext);
	}

	/**
	 * Voids (cancels) an Order.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return Order
	 * @throws PayPalRESTException
	 */
	public Order doVoid(APIContext apiContext) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "v1/payments/orders/{0}/do-void";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Order.class);
	}


	/**
	 * Creates an authorization on an order
	 * @deprecated Please use {@link #authorize(APIContext)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @return Authorization
	 * @throws PayPalRESTException
	 */
	public Authorization authorize(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return authorize(apiContext);
	}

	/**
	 * Creates an authorization on an order
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return Authorization
	 * @throws PayPalRESTException
	 */
	public Authorization authorize(APIContext apiContext) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "v1/payments/orders/{0}/authorize";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = this.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Authorization.class);
	}


}
