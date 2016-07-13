package com.paypal.api.payments;

import com.google.gson.annotations.SerializedName;
import com.paypal.base.rest.PayPalModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Template extends PayPalModel {

	/**
	 * Unique identifier id of the template.
	 */
	private String templateId;

	/**
	 * Name of the template.
	 */
	private String name;

	/**
	 * Indicates that this template is merchant's default. There can be only one template which can be a default.
	 */
	@SerializedName("default")
	private Boolean isDefault;

	/**
	 * Customized invoice data which is saved as template
	 */
	private TemplateData templateData;

	/**
	 * Settings for each template
	 */
	private List<TemplateSettings> settings;

	/**
	 * Unit of measure for the template, possible values are Quantity, Hours, Amount.
	 */
	private String unitOfMeasure;

	/**
	 * Indicates whether this is a custom template created by the merchant. Non custom templates are system generated
	 */
	private Boolean custom;

	/**
	 * Default Constructor
	 */
	public Template() {
	}

}
