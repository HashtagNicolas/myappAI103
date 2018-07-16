package fr.afcepf.ai103.service;

import fr.afcepf.ai103.data.Client;

public class ServiceClient {
	public Client rechercherInfoClient(Long numClient) {
		Client cli = new Client();

		cli.setNumClient(numClient);
		cli.setPrenom("Jean");
		cli.setNom("bon");
		cli.setAdresse("30 rue elle 75006 paris");
		cli.setEmail("jambon@gmail.com");
		cli.setTelephone("0601020304");
		
		return cli;
	}

}
