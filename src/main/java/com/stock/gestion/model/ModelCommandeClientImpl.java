package com.stock.gestion.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.stock.gestion.entites.Article;
import com.stock.gestion.entites.Client;
import com.stock.gestion.entites.CommandeClient;
import com.stock.gestion.entites.LigneCommandeClient;


@Component
public class ModelCommandeClientImpl implements ModelCommandeClient{
    
	private CommandeClient commande;
	private Map<Long, LigneCommandeClient> ligneCde = new  HashMap<Long, LigneCommandeClient>();
	
	
	@Override
	public void creerCommande(Client client) {
		if(client == null) {
			return;
		}
		commande = new CommandeClient();
		commande.setClient(client);
		commande.setDateCommande(new Date());
		commande.setCode(generateCodeCommande());
		
	}

	@Override
	public LigneCommandeClient ajouterligneCommande(Article article) {
		if(article == null) {
			return null;
		}
		LigneCommandeClient lc = ligneCde.get(article.getIdArticle());
		if(lc != null) {
			BigDecimal qte = lc.getQuantite().add(BigDecimal.ONE);
			lc.setQuantite(qte);
			ligneCde.put(article.getIdArticle(),lc);
			return lc;
		}else {
			 LigneCommandeClient ligne = new  LigneCommandeClient();
			 ligne.setCommandeClient(commande);
			 ligne.setQuantite(BigDecimal.ONE);
			 ligne.setPrixUnitaire(article.getPrixUnitaireTTC());
			 ligne.setArticle(article);
			 ligneCde.put(article.getIdArticle(),ligne);
			 return ligne;
		}
		
	}

	@Override
	public LigneCommandeClient supprimerLigneCommande(Article article) {
		if(article == null) {
			return null;
		}
		return ligneCde.remove(article.getIdArticle());
	}

	@Override
	public LigneCommandeClient modifierQuantite(Article article, double qte) {
		if(article == null) {
			return null;
		}
		LigneCommandeClient lc = ligneCde.get(article.getIdArticle());
		if(lc == null) {
			return null;
		}
		lc.setQuantite(BigDecimal.valueOf(qte));
		return lc;
	}


	@Override
	public String generateCodeCommande() {
		return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
	}
    
	@Override
	public CommandeClient getCommande() {
		return commande;
	}

	public void setCommande(CommandeClient commande) {
		this.commande = commande;
	}
    
	@Override
	public Map<Long, LigneCommandeClient> getLigneCde() {
		return ligneCde;
	}

	public void setLigneCde(Map<Long, LigneCommandeClient> ligneCde) {
		this.ligneCde = ligneCde;
	}
    
	
}
