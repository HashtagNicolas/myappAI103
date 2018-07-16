package fr.afcepf.ai103.dao;

import java.util.List;

import fr.afcepf.ai103.data.Client;
/*
 * DAO = Data Access Object
 * avec méthode CRUD : Create, Retrieve, Update, Delete
 * avec throws RuntimeException implicites
 */
public interface IDaoClient {
	public Client insererNouveauxClient(Client p);
	
	public Client rechercherClientParNumero(Long numero);
	public List<Client> rechercherClients();
	//... autres recherches
	public void MettreAjourClient(Client p);
	public void SupprimerClient(Long numero);
}
