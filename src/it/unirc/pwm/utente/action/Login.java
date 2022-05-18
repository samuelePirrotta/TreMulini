package it.unirc.pwm.utente.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.utente.Utente;
import it.unirc.pwm.utente.UtenteDAO;
import it.unirc.pwm.utente.UtenteDAOFactory;

public class Login extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private Map<String,Object> session;
	
	public String getUsername() {
		return username;
	}	
	public void setUsername(String username) {
		this.username = username;
	}	
	public String getPassword() {
		return password;
	}	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() throws Exception {
		UtenteDAO uDAO = UtenteDAOFactory.getDao();
		Utente entry = new Utente();
		entry.setNome(this.getUsername());
		entry.setPassword(this.getPassword());
		Utente res = uDAO.login(entry);
		if(res.getNome().equals(this.getUsername()) && res.getPassword().equals(this.getPassword())) {
			session.put("utente", res);
			return SUCCESS;
		} else {
			throw new Exception("Username o Password Errati");
		}
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}