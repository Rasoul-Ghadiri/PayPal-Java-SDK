package com.paypal.api.sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.paypal.api.payments.Patch;
import com.paypal.api.payments.Plan;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class SubscriptionSample extends SampleBase<Plan> {
	public static final String clientID = "AYSq3RDGsmBLJE-otTkBtM-jBRd1TCQwFf9RGfwddNXWz0uFU9ztymylOhRS";
	public static final String clientSecret = "EGnHDxD_qRPdaLdZz8iCr8N7_MzF-YHPTkjs6NKYQvQSBngp4PTTVWkPZRbL";

	public SubscriptionSample() throws PayPalRESTException,
			JsonSyntaxException, JsonIOException, FileNotFoundException {
		super(new Plan());
	}

	/**
	 * Create a plan.
	 *
	 * https://developer.paypal.com/webapps/developer/docs/api/#create-a-plan
	 *
	 * @return newly created Plan instance
	 * @throws PayPalRESTException
	 */
	public Plan create(APIContext context) throws PayPalRESTException, IOException {
		// populate Plan object that we are going to play with
		super.instance = super.load("billingplan_create.json", Plan.class);
		super.instance = super.instance.create(context);
		return super.instance;
	}

	/**
	 * Update a plan
	 *
	 * https://developer.paypal.com/webapps/developer/docs/api/#update-a-plan
	 *
	 * @return updated Plan instance
	 * @throws PayPalRESTException
	 */
	public Plan update(APIContext context) throws PayPalRESTException, IOException {
		Patch[] patch = super.load("billingplan_update.json", Patch[].class);
		super.instance.update(context, Arrays.asList(patch));
		return super.instance;
	}

	/**
	 * Retrieve a plan
	 *
	 * https://developer.paypal.com/webapps/developer/docs/api/#retrieve-a-plan
	 *
	 * @return the retrieved plan
	 * @throws PayPalRESTException
	 */
	public Plan retrieve(APIContext context) throws PayPalRESTException {
		return Plan.get(context, super.instance.getId());
	}

	/**
	 * Main method that calls all methods above in a flow.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SubscriptionSample subscriptionSample = new SubscriptionSample();

			APIContext context = new APIContext(clientID, clientSecret, "sandbox");
			
			Plan plan = subscriptionSample.create(context);
			System.out.println("create response:\n" + Plan.getLastResponse());
			plan = subscriptionSample.update(context);
			System.out.println("plan updated");
			plan = subscriptionSample.retrieve(context);
			System.out.println("retrieve response:\n" + Plan.getLastResponse());
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
