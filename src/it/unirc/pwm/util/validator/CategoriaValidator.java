package it.unirc.pwm.util.validator;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class CategoriaValidator extends FieldValidatorSupport {


	public void validate(Object arg0) throws ValidationException {
		int tmp = (Integer) this.getFieldValue(this.getFieldName(), arg0);
		if(tmp == -1) {
			addFieldError(getFieldName(), arg0);
		}
	}
}