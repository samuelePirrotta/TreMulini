package it.unirc.pwm.ordine_piatto;

public class OrdinePiattoId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idOrdine;
	private int idPiatto;

	public OrdinePiattoId() {
	}

	public OrdinePiattoId(int idOrdine, int idPiatto) {
		this.idOrdine = idOrdine;
		this.idPiatto = idPiatto;
	}

	public int getIdOrdine() {
		return this.idOrdine;
	}
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	public int getIdPiatto() {
		return this.idPiatto;
	}
	public void setIdPiatto(int idPiatto) {
		this.idPiatto = idPiatto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrdinePiattoId))
			return false;
		OrdinePiattoId castOther = (OrdinePiattoId) other;

		return (this.getIdOrdine() == castOther.getIdOrdine()) && (this.getIdPiatto() == castOther.getIdPiatto());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdOrdine();
		result = 37 * result + this.getIdPiatto();
		return result;
	}
}