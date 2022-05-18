package it.unirc.pwm.util.validator;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/*
 * Il validator, per essere utilizzabile nella validazione xml, deve essere
 * dichiarato nel file validators.xml presente in /src
 */
public class PasswordStrenghtValidator extends FieldValidatorSupport {
	/*
	 * Pattern è un tipo Java per gestire le espressioni regolari.
	 * Vedi [http://download.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html]
	 */
	static Pattern maiuscole = Pattern.compile("[A-Z]");
	static Pattern minuscole = Pattern.compile("[a-z]");
	static Pattern numeri = Pattern.compile("[0-9]");
	
	public void validate(Object arg0) throws ValidationException {
		/*
		 * getFieldValue() prende due parametri:
		 * 	name: il nome del campo
		 *  object: l'oggetto form, lo stesso che viene passato al metodo validate()
		 */
		String inputPassword = (String) this.getFieldValue(this.getFieldName(), arg0);
		
		Boolean passContieneMinuscole = minuscole.matcher(inputPassword).find();
		Boolean passContieneMaiuscole = maiuscole.matcher(inputPassword).find();
		Boolean passContieneNumeri = numeri.matcher(inputPassword).find();
		
		if(!passContieneMinuscole||!passContieneMaiuscole||!passContieneNumeri){
			addFieldError(getFieldName(), arg0);
		}
	}
}