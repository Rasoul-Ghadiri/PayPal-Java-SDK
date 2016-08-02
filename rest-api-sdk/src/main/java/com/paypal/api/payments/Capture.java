package com.paypal.api.payments;

import com.paypal.base.rest.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Capture  extends PayPalResource {

	/**
	 * ID of the capture transaction.
	 */
	private String id;

	/**
	 * Amount being captured. If the amount matches the orginally authorized amount, the state of the authorization changes to `captured`. If not, the state of the authorization changes to `partially_captured`.
	 */
	private Amount amount;

	/**
	 * If set to `true`, all remaining funds held by the authorization will be released in the funding instrument.
	 */
	private Boolean isFinalCapture;

	/**
	 * State of the capture.
	 */
	private String state;

	/**
	 * ID of the payment resource on which this transaction is based.
	 */
	private String parentPayment;

	/**
	 * Transaction fee applicable for this payment.
	 */
	private Currency transactionFee;

	/**
	 * Time of capture as defined in [RFC 3339 Section 5.6](http://tools.ietf.org/html/rfc3339#section-5.6).
	 */
	private String createTime;

	/**
	 * Time that the resource was last updated.
	 */
	private String updateTime;

	/**
	 * 
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Capture() {
	}

	/**
	 * Obtain the Capture transaction resource for the given identifier.
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param captureId
	 *            String
	 * @return Capture
	 * @throws PayPalRESTException
	 */
	public static Capture get(String accessToken, String captureId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, captureId);
	}

	/**
	 * Obtain the Capture transaction resource for the given identifier.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param captureId
	 *            String
	 * @return Capture
	 * @throws PayPalRESTException
	 */
	public static Capture get(APIContext apiContext, String captureId) throws PayPalRESTException {

		if (captureId == null) {
			throw new IllegalArgumentException("captureId cannot be null");
		}
		Object[] parameters = new Object[] {captureId};
		String pattern = "v1/payments/capture/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Capture.class);
	}


	/**
	 * Creates (and processes) a new Refund Transaction added as a related resource.
	 * @deprecated Please use {@link #refund(APIContext, Refund)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param refund
	 *            Refund
	 * @return Refund
	 * @throws PayPalRESTException
	 */
	public Refund refund(String accessToken, Refund refund) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return refund(apiContext, refund);
	}

	/**
	 * Creates (and processes) a new Refund Transaction added as a related resource.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param refund
	 *            Refund
	 * @return Refund
	 * @throws PayPalRESTException
	 */
	public Refund refund(APIContext apiContext, Refund refund) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (refund == null) {
			throw new IllegalArgumentException("refund cannot be null");
		}
		apiContext.setRequestId(null);
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "v1/payments/capture/{0}/refund";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = refund.toJSON();
		Refund refundResponse = configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Refund.class);
		apiContext.setRequestId(null);
		return refundResponse;
	}


}
