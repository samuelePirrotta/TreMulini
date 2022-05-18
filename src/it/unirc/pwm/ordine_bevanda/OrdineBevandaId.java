package it.unirc.pwm.ordine_bevanda;

public class OrdineBevandaId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idOrdine;
	private int idBevanda;

	public OrdineBevandaId(){}

	public OrdineBevandaId(int idOrdine, int idBevanda) {
		this.idOrdine = idOrdine;
		this.idBevanda = idBevanda;
	}

	public int getIdOrdine() {
		return this.idOrdine;
	}
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	public int getIdBevanda() {
		return this.idBevanda;
	}
	public void setIdBevanda(int idBevanda) {
		this.idBevanda = idBevanda;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrdineBevandaId))
			return false;
		OrdineBevandaId castOther = (OrdineBevandaId) other;

		return (this.getIdOrdine() == castOther.getIdOrdine()) && (this.getIdBevanda() == castOther.getIdBevanda());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdOrdine();
		result = 37 * result + this.getIdBevanda();
		return result;
	}
}