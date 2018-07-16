//import.sql est un script SQL automatiquement déclenché par hibernate
//au démarrage de appli (ou test) en mode hibernate.hdm2ddd1.auto=create

INSERT INTO Client(numClient,prenom,nom,email,adresse,telephone,password) VALUES (1,'Jean','Bon','jean.bon@gmail.com','1 rue elle 75006 Paris','0102030405','pwd1')
INSERT INTO Client(numClient,prenom,nom,email,adresse,telephone,password) VALUES (2,'Axelle','Air','axl.air@gmail.com','1 rue coucou 75012 Paris', '0102030405','pwd2')