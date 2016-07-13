package com.paypal.api.payments;

import com.paypal.base.rest.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Templates extends PayPalResource {

	/**
	 * List of addresses in merchant's profile.
	 */
	private List<Address> addresses;

	/**
	 * List of emails in merchant's profile.
	 */
	private List<String> emails;

	/**
	 * List of phone numbers in merchant's profile.
	 */
	private List<Phone> phones;

	/**
	 * Array of templates.
	 */
	private List<Template> templates;

	/**
	 * HATEOS links representing all the actions over the template list returned.
	 */
	private List<Links> links;

	/**
	 * Default Constructor
	 */
	public Templates() {
	}

	/**
	 * Shows the details for a template, by ID.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @param templateId
	 *            String
	 * @return Template
	 * @throws PayPalRESTException
	 */
	public static Template get(APIContext apiContext, String templateId) throws PayPalRESTException {
		if (templateId == null) {
			throw new IllegalArgumentException("templateId cannot be null");
		}
		Object[] parameters = new Object[] {templateId};
		String pattern = "v1/invoicing/templates/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Template.class);
	}

	/**
	 * Lists all templates for the merchant.
	 * @param apiContext
	 *            {@link APIContext} used for the API call.
	 * @return Templates
	 * @throws PayPalRESTException
	 */
	public static Templates getAll(APIContext apiContext) throws PayPalRESTException {
		String resourcePath = "v1/invoicing/templates";
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Templates.class);
	}

}
