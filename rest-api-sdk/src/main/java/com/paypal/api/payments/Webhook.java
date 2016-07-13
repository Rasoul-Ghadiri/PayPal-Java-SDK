package com.paypal.api.payments;

import com.paypal.base.rest.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Webhook  extends PayPalResource {

	/**
	 * Identifier of the webhook resource.
	 */
	private String id;

	/**
	 * Webhook notification endpoint url.
	 */
	private String url;

	/**
	 * List of Webhooks event-types.
	 */
	private List<EventType> eventTypes;

	/**
	 * Hateoas Links.
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Webhook() {
	}

	/**
	 * Parameterized Constructor
	 */
	public Webhook(String url, List<EventType> eventTypes) {
		this.url = url;
		this.eventTypes = eventTypes;
	}
	
	/**
	 * Creates the Webhook for the application associated with the access token.
	 * @deprecated Please use {@link #create(APIContext, Webhook)} instead.
	 *
	 * @param accessToken
	 *            Access Token used for the API call.	
	 * @param webhook
	 *            Webhook Request
	 * @return Webhook
	 * @throws PayPalRESTException
	 */
	public Webhook create(String accessToken, Webhook webhook) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return create(apiContext, webhook);
	}

	/**
	 * Creates the Webhook for the application associated with the access token.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.	 
	 * @param webhook
	 *            Webhook Request
	 * @return Webhook
	 * @throws PayPalRESTException
	 */
	public Webhook create(APIContext apiContext, Webhook webhook) throws PayPalRESTException {
		if (webhook == null) {
			throw new IllegalArgumentException("webhook cannot be null");
		}

		Object[] parameters = new Object[] {};
		String pattern = "v1/notifications/webhooks";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = webhook.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Webhook.class);
	}
	
	/**
	 * Retrieves the Webhook identified by webhook_id for the application associated with access token.
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 *
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param webhookId
	 *            Identifier of the webhook
	 * @return Webhook
	 * @throws PayPalRESTException
	 */
	public Webhook get(String accessToken, String webhookId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, webhookId);
	}

	/**
	 * Retrieves the Webhook identified by webhook_id for the application associated with access token.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param webhookId
	 *            Identifier of the webhook
	 * @return Webhook
	 * @throws PayPalRESTException
	 */
	public Webhook get(APIContext apiContext, String webhookId) throws PayPalRESTException {
		if (webhookId == null) {
			throw new IllegalArgumentException("webhookId cannot be null");
		}

		Object[] parameters = new Object[] {webhookId};
		String pattern = "v1/notifications/webhooks/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Webhook.class);
	}

	/**
	 * Updates the Webhook identified by webhook_id for the application associated with access token.
	 * @deprecated Please use {@link #update(APIContext, String, String)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param webhookId
	 *            Identifier of the webhook
	 * @param patchRequest
	 *            patchRequest
	 * @return Webhook
	 * @throws PayPalRESTException
	 */
	public Webhook update(String accessToken, String webhookId, String patchRequest) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return update(apiContext, webhookId, patchRequest);
	}

	/**
	 * Updates the Webhook identified by webhook_id for the application associated with access token.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param webhookId
	 *            Identifier of the webhook
	 * @return Webhook
	 * @throws PayPalRESTException
	 */
	public Webhook update(APIContext apiContext, String webhookId, String patchRequest) throws PayPalRESTException {
		if (webhookId == null) {
			throw new IllegalArgumentException("webhookId cannot be null");
		}
		if (patchRequest == null) {
			throw new IllegalArgumentException("patchRequest cannot be null");
		}

		Object[] parameters = new Object[] {webhookId};
		String pattern = "v1/notifications/webhooks/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = patchRequest;
		return configureAndExecute(apiContext, HttpMethod.PATCH, resourcePath, payLoad, Webhook.class);
	}
	
	/**
	 * Deletes the Webhook identified by webhook_id for the application associated with access token.
	 * @deprecated Please use {@link #delete(APIContext, String)} instead.
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param webhookId
	 *            Identifier of the webhook
	 * @throws PayPalRESTException
	 */
	public void delete(String accessToken, String webhookId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		delete(apiContext, webhookId);
	}

	/**
	 * Deletes the Webhook identified by webhook_id for the application associated with access token.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param webhookId
	 *            Identifier of the webhook
	 * @throws PayPalRESTException
	 */
	public void delete(APIContext apiContext, String webhookId) throws PayPalRESTException {
		if (webhookId == null) {
			throw new IllegalArgumentException("webhookId cannot be null");
		}

		Object[] parameters = new Object[] {webhookId};
		String pattern = "v1/notifications/webhooks/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		configureAndExecute(apiContext, HttpMethod.DELETE, resourcePath, payLoad, null);
	}
	

}