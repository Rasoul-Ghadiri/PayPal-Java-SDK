package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CreateProfileResponse  extends PayPalModel {

	/**
	 * ID of the payment web experience profile.
	 */
	private String id;

	/**
	 * Default Constructor
	 */
	public CreateProfileResponse() {
	}
}
