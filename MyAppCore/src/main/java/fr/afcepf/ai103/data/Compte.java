package fr.afcepf.ai103.data;

public class Compte {

	private Long numero;
	private String label;
	private Double solde;
	
	
	public Compte() {
		super();
	}
	
	//getter setter
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	
}
