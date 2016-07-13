package com.paypal.api.payments;

import com.paypal.base.rest.*;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WebProfile extends PayPalResource {

	/**
	 * Unique ID of the web experience profile.
	 */
	private String id;

	/**
	 * Name of the web experience profile. Unique only among the profiles for a given merchant.
	 */
	private String name;

	/**
	 * Parameters for flow configuration.
	 */
	private FlowConfig flowConfig;

	/**
	 * Parameters for input fields customization.
	 */
	private InputFields inputFields;

	/**
	 * Parameters for style and presentation.
	 */
	private Presentation presentation;

	/**
	 * Default Constructor
	 */
	public WebProfile() {
	}

	/**
	 * Parameterized Constructor
	 */
	public WebProfile(String name) {
		this.name = name;
	}
	
	/**
	 * Create a web experience profile by passing the name of the profile and other profile details in the request JSON to the request URI.
	 * @deprecated Please use {@link #create(APIContext)} instead.
	 *
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @return CreateProfileResponse
	 * @throws PayPalRESTException
	 */
	public CreateProfileResponse create(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return create(apiContext);
	}

	/**
	 * Create a web experience profile by passing the name of the profile and other profile details in the request JSON to the request URI.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return CreateProfileResponse
	 * @throws PayPalRESTException
	 */
	public CreateProfileResponse create(APIContext apiContext) throws PayPalRESTException {
		String resourcePath = "v1/payment-experience/web-profiles";
		String payLoad = this.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, CreateProfileResponse.class);
	}


	/**
	 * Update a web experience profile by passing the ID of the profile to the request URI. In addition, pass the profile details in the request JSON. If your request does not include values for all profile detail fields, the previously set values for the omitted fields are removed by this operation.
	 * @deprecated Please use {@link #update(APIContext)} instead.
	 *
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @throws PayPalRESTException
	 */
	public void update(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		update(apiContext);
	}

	/**
	 * Update a web experience profile by passing the ID of the profile to the request URI. In addition, pass the profile details in the request JSON. If your request does not include values for all profile detail fields, the previously set values for the omitted fields are removed by this operation.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @throws PayPalRESTException
	 */
	public void update(APIContext apiContext) throws PayPalRESTException {
		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "v1/payment-experience/web-profiles/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = this.toJSON();
		configureAndExecute(apiContext, HttpMethod.PUT, resourcePath, payLoad, null);
	}


	/**
	 * Partially update an existing web experience profile by passing the ID of the profile to the request URI. In addition, pass a patch object in the request JSON that specifies the operation to perform, path of the profile location to update, and a new value if needed to complete the operation.
	 * @deprecated Please use {@link #partialUpdate(APIContext, PatchRequest)} instead.
	 *
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param patchRequest
	 *            PatchRequest
	 * @throws PayPalRESTException
	 */
	public void partialUpdate(String accessToken, PatchRequest patchRequest) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		partialUpdate(apiContext, patchRequest);
	}

	/**
	 * Partially update an existing web experience profile by passing the ID of the profile to the request URI. In addition, pass a patch object in the request JSON that specifies the operation to perform, path of the profile location to update, and a new value if needed to complete the operation.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param patchRequest
	 *            PatchRequest
	 * @throws PayPalRESTException
	 */
	public void partialUpdate(APIContext apiContext, PatchRequest patchRequest) throws PayPalRESTException {
		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		if (patchRequest == null) {
			throw new IllegalArgumentException("patchRequest cannot be null");
		}
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "v1/payment-experience/web-profiles/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = patchRequest.toJSON();
		configureAndExecute(apiContext, HttpMethod.PATCH, resourcePath, payLoad, null);
	}


	/**
	 * Retrieve the details of a particular web experience profile by passing the ID of the profile to the request URI.
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 *
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @param profileId
	 *            String
	 * @return WebProfile
	 * @throws PayPalRESTException
	 */
	public static WebProfile get(String accessToken, String profileId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, profileId);
	}

	/**
	 * Retrieve the details of a particular web experience profile by passing the ID of the profile to the request URI.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param profileId
	 *            String
	 * @return WebProfile
	 * @throws PayPalRESTException
	 */
	public static WebProfile get(APIContext apiContext, String profileId) throws PayPalRESTException {
		if (profileId == null) {
			throw new IllegalArgumentException("profileId cannot be null");
		}
		Object[] parameters = new Object[] {profileId};
		String pattern = "v1/payment-experience/web-profiles/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, WebProfile.class);
	}


	/**
	 * Lists all web experience profiles that exist for a merchant (or subject).
	 * @deprecated Please use {@link #getList(APIContext)} instead.
	 *
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @return WebProfileList
	 * @throws PayPalRESTException
	 */
	public static List<WebProfile> getList(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return getList(apiContext);
	}

	/**
	 * Lists all web experience profiles that exist for a merchant (or subject).
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return WebProfileList
	 * @throws PayPalRESTException
	 */
	public static List<WebProfile> getList(APIContext apiContext) throws PayPalRESTException {
		String resourcePath = "v1/payment-experience/web-profiles";
		String payLoad = "";
		List<WebProfile> webProfiles = configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, WebProfileList.class);
		
		return webProfiles;
	}


	/**
	 * Delete an existing web experience profile by passing the profile ID to the request URI.
	 * @deprecated Please use {@link #delete(APIContext)} instead.
	 *
	 * @param accessToken
	 *            Access Token used for the API call.
	 * @throws PayPalRESTException
	 */
	public void delete(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		delete(apiContext);
	}

	/**
	 * Delete an existing web experience profile by passing the profile ID to the request URI.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @throws PayPalRESTException
	 */
	public void delete(APIContext apiContext) throws PayPalRESTException {

		if (this.getId() == null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
			apiContext.setMaskRequestId(true);
		Object[] parameters = new Object[] {this.getId()};
		String pattern = "v1/payment-experience/web-profiles/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		configureAndExecute(apiContext, HttpMethod.DELETE, resourcePath, payLoad, null);
	}
}
