package com.stock.gestion.model;

import java.util.Map;

import com.stock.gestion.entites.Article;
import com.stock.gestion.entites.Client;
import com.stock.gestion.entites.CommandeClient;
import com.stock.gestion.entites.LigneCommandeClient;

public interface ModelCommandeClient {
	
     void creerCommande(Client client);
     
     LigneCommandeClient ajouterligneCommande(Article article);
     
     LigneCommandeClient supprimerLigneCommande(Article article);
     
     LigneCommandeClient modifierQuantite(Article article,double qte);
     
     String generateCodeCommande();
     
     CommandeClient getCommande();
     
     Map<Long, LigneCommandeClient> getLigneCde();
     
}
