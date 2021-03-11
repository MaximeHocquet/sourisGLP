package element;

public class Comportement {
	private Communication communication;
	private Sociabilite sociabilite;
	public Comportement(Communication communication, Sociabilite sociabilite) {
		this.communication = communication;
		this.sociabilite = sociabilite;
	}
	public Communication getCommunication() {
		return communication;
	}
	public Sociabilite getSociabilite() {
		return sociabilite;
	}
	public void setCommunication(Communication communication) {
		this.communication = communication;
	}
	public void setSociabilite(Sociabilite sociabilite) {
		this.sociabilite = sociabilite;
	}
	
}
