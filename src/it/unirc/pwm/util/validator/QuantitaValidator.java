package it.unirc.pwm.util.validator;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class QuantitaValidator extends FieldValidatorSupport {

	public void validate(Object arg0) throws ValidationException {
		int tmp = (Integer) this.getFieldValue(this.getFieldName(), arg0);
		if(tmp == 0 || tmp < 0) {
			addFieldError(getFieldName(), arg0);
		}
	}
}