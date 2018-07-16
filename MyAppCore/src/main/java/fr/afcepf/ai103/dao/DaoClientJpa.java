package fr.afcepf.ai103.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.afcepf.ai103.data.Client;

public class DaoClientJpa implements IDaoClient {
	
	private EntityManager entityManager;
	
	private void initEntityMangerSansEjb() {
		//1. créer l'objet technique EntityManagerFactory de JPA
		//en analysant le fichier META-INF/persitence.xml
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyAppCore");
		
		//myappCore est un nom logique d'une Party de la config de META-INF/persitence.xml
		//2.créer le EntityManager via la factory
		//factory est une sorte d'initialisation qui effectue un paramétrage
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	public DaoClientJpa() {
		initEntityMangerSansEjb();
	}

	@Override
	public Client insererNouveauxClient(Client c) {
		try {
			entityManager.getTransaction().begin();
			// en entrée la partie c.numClient vaut null
			entityManager.persist(c); //INSERT INTO SQL avec auto_incrementation
			entityManager.getTransaction().commit();
			return c; //en retour c.numClient ne sera plus null
		} catch (Exception e) {
			// TODO Auto-generated catch block
			entityManager.getTransaction().rollback(); //annuler si l'insert ne marche pas
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Client rechercherClientParNumero(Long numero) {
		//SELECT FROM ...... WHERE numero= ?
		return entityManager.find(Client.class, numero);
	}

	@Override
	public List<Client> rechercherClients() {
		return entityManager.createQuery("SELECT c From Client c",Client.class).getResultList();
	}

	@Override
	public void MettreAjourClient(Client c) {
		try {
			entityManager.getTransaction().begin();
			//update
			entityManager.merge(c);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().commit();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void SupprimerClient(Long numero) {
		try {
			entityManager.getTransaction().begin();
			Client c = entityManager.find(Client.class, numero);
			entityManager.remove(c);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().commit();
			e.printStackTrace();
			throw e;
		}

	}

}
