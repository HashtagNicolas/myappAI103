package fr.afcepf.ai103.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.data.Operation;

public class ServiceCompte {
	
	private Long numCpt1 = 123456L;
	private Long numCpt2 = 952435L;
	
	private Map<Long, Compte> mapComptes = new HashMap<>();
	
	public ServiceCompte() {

		
		Compte cpt1 = new Compte();
		cpt1.setNumero(numCpt1);
		cpt1.setLabel("compte courant");
		cpt1.setSolde(500.0);
		mapComptes.put(cpt1.getNumero(), cpt1);
		
		Compte cpt2 = new Compte();
		cpt2.setNumero(numCpt2);
		cpt2.setLabel("compte secondaire");
		cpt2.setSolde(300.0);
		mapComptes.put(cpt2.getNumero(), cpt2);
		
	}
	
	public void transferer(Double montant, Long numCptDeb, Long numCptCred) {
		Compte cptDeb = mapComptes.get(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde() - montant);
		
		Compte cptCred = mapComptes.get(numCptCred);
		cptCred.setSolde(cptCred.getSolde() + montant);
	}
	
	public List<Compte> comptesDuClient(Long numClient){
		List<Compte> listeComptes = new ArrayList<Compte>();
		
		//simulation de valeurs récupérées en base :
		listeComptes.add(mapComptes.get(numCpt1));
		listeComptes.add(mapComptes.get(numCpt2));
		
		return listeComptes;
	}
	
	public List<Operation> operationDuCompte(Long numCompte){
		List<Operation> listeOperations = new ArrayList<>();
		//simulation de valeurs récuperées en base:
		if(numCompte != null && (numCompte % 2) == 0) {
		listeOperations.add(new Operation(1L, new Date(), -30.0, "achat livres"));
		listeOperations.add(new Operation(2L, new Date(), -10.0, "achat dvd"));
		}
		else {
			listeOperations.add(new Operation(1L, new Date(), -35.0, "achat vetements"));
			listeOperations.add(new Operation(2L, new Date(), -18.0, "achat crème solaire"));
		}
		return listeOperations;
		
	}
}
