package com.paypal.api.payments;

import com.paypal.base.rest.PayPalModel;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Presentation  extends PayPalModel {

	/**
	 * A label that overrides the business name in the PayPal account on the PayPal pages. Character length and limitations: 127 single-byte alphanumeric characters.
	 */
	private String brandName;

	/**
	 * A URL to logo image. Allowed vaues: `.gif`, `.jpg`, or `.png`. Limit the image to 190 pixels wide by 60 pixels high. PayPal crops images that are larger. PayPal places your logo image at the top of the cart review area. PayPal recommends that you store the image on a secure (https) server. Otherwise, web browsers display a message that checkout pages contain non-secure items. Character length and limit: 127 single-byte alphanumeric characters.
	 */
	private String logoImage;

	/**
	 * Locale of pages displayed by PayPal payment experience. Allowed values: `AU`, `AT`, `BE`, `BR`, `CA`, `CH`, `CN`, `DE`, `ES`, `GB`, `FR`, `IT`, `NL`, `PL`, `PT`, `RU`, `US`. The following 5-character codes are also allowed for languages in specific countries: `da_DK`, `he_IL`, `id_ID`, `ja_JP`, `no_NO`, `pt_BR`, `ru_RU`, `sv_SE`, `th_TH`, `tr_TR`, `zh_CN`, `zh_HK`, `zh_TW`.
	 */
	private String localeCode;

	/**
	 * Default Constructor
	 */
	public Presentation() {
	}
}
