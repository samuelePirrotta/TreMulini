package it.unirc.pwm.utente.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport {

	private static final long serialVersionUID = 1L;
	protected static final Map<String, Object> session = ActionContext.getContext().getSession();
	
	public String execute() {
		session.clear();
		return SUCCESS;
	}
}