package fr.afcepf.ai103.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.afcepf.ai103.data.Client;
import fr.afcepf.ai103.service.ServiceClient;

@ManagedBean //de JSF2 , nom logique par défaut = "calculBean" 
// = nom de la classe avec minuscule au début
@RequestScoped
public class ClientBean {
	private Long numClient;
	private String password;
	private String message;
	private Client client; //info "client" à recupérer
	
	private ServiceClient serviceClient = new ServiceClient();
	
	public String verifLogin() {
    	String suite=null; /* si suite reste à null on reste sur même page */
    	//simuler verification du mot de passe:
    	if(password!=null && password.equals("pwd" + numClient)) {
    		//mot de passe considéré comme ok si "pwd" + numClient (ex: "pwd1" )
    		//on demande à naviguer vers la page client
    		
    		this.client = serviceClient.rechercherInfoClient(numClient);
    		
    		suite = "client"; //.jsf (.jsp ou .xhtml)
    	}else {
    		message = "invalid password"; 
    	}
    	return suite;
    }

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
	
	
	
}
