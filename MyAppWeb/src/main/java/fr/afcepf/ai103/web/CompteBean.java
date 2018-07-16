package fr.afcepf.ai103.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.data.Operation;
import fr.afcepf.ai103.service.ServiceCompte;

@ManagedBean
@SessionScoped
public class CompteBean {
	
	private Long numClient = null; //sera amélioré plus tard (numClient = 1 par defaut)
	
	private ServiceCompte serviceCompte = new ServiceCompte();
	
	private Long numCptDeb = null; // à sélectionner dans liste déroulante dans virement.xhtml
	private Long numCptCred = null; // à sélectionner dans liste déroulante dans virement.xhtml
	private Double montant = null; //à saisir dans virement.xhtml
	
	private List<Compte> comptes; //à afficher sous forme de tableau (h:dataTable)
	private List<Operation> operations; //à afficher sous forme de tableau (h:dataTable)

	private Long selectedNumCompte = null;
	
	
	public String onSelectCompte() {
		operations = serviceCompte.operationDuCompte(selectedNumCompte);
		return null;
	}
	
	//constructeur par défaut:
	public CompteBean() {
		operations = new ArrayList<Operation>();
		//super(); //declencher la class dont on hérite
	}
	//méthode appelée après que numClient soit automatiquement mis à jour par JSF
	public void initComptes(ComponentSystemEvent event){
		comptes = serviceCompte.comptesDuClient(numClient);
	}
	
	public String EffectuerVirement() {
		String suite = null;
		serviceCompte.transferer(montant, numCptDeb, numCptCred);
		//recharger en mémoire les nouveaux soldes qui ont évolués et qui seront réafficher
		this.comptes = serviceCompte.comptesDuClient(numClient);
		//demandé à naviguer vers comptes.xhtml pour réafficher les comptes
		suite="comptes"; //comptes.xhtml
		return suite;
	}
	
	
	//get set
	
	
	public Long getNumClient() {
		return numClient;
	}

	public Long getSelectedNumCompte() {
		return selectedNumCompte;
	}

	public void setSelectedNumCompte(Long selectedNumCompte) {
		this.selectedNumCompte = selectedNumCompte;
	}

	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public Long getNumCptDeb() {
		return numCptDeb;
	}

	public void setNumCptDeb(Long numCptDeb) {
		this.numCptDeb = numCptDeb;
	}

	public Long getNumCptCred() {
		return numCptCred;
	}

	public void setNumCptCred(Long numCptCred) {
		this.numCptCred = numCptCred;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public ServiceCompte getServiceCompte() {
		return serviceCompte;
	}

	public void setServiceCompte(ServiceCompte serviceCompte) {
		this.serviceCompte = serviceCompte;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	
	
	
}
