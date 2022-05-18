package it.unirc.pwm.ordine;

import java.util.List;

public interface OrdineDAO {
	public Ordine getOrdine(Ordine o);
	public List<Ordine> getOrdini();
	public int saveOrdine(Ordine o);
	public boolean updateOrdine(Ordine o);
	public boolean deleteOrdine(Ordine o);
}