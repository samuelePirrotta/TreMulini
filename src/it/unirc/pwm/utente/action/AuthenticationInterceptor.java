package it.unirc.pwm.utente.action;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import it.unirc.pwm.utente.Utente;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger("AuthenticationInterceptor");

	public void destroy() {}
	
	public void init() {}

	public String intercept( ActionInvocation actionInvocation ) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		logger.info("Autenticazione avviata!");
		
		Utente utente = (Utente) session.get("utente");
		
		if (utente == null) {
		    return Action.LOGIN;
		}
		else {
		    Action action = (Action) actionInvocation.getAction();
		    
		    if (action instanceof UtenteAware) {
		        ((UtenteAware)action).setUtente(utente);
		    }
		    return actionInvocation.invoke();
		}
	}
}