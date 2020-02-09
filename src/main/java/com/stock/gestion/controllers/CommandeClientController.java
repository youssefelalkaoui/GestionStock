package com.stock.gestion.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stock.gestion.entites.Article;
import com.stock.gestion.entites.Client;
import com.stock.gestion.entites.CommandeClient;
import com.stock.gestion.entites.LigneCommandeClient;
import com.stock.gestion.model.ModelCommandeClient;
import com.stock.gestion.services.IArticleService;
import com.stock.gestion.services.IClientService;
import com.stock.gestion.services.ICommandeClientService;
import com.stock.gestion.services.ILigneCommandeClientService;

@Controller
@RequestMapping(value = "/commandeClient")
public class CommandeClientController {
	
	@Autowired
	private ICommandeClientService commandeService;
	
	@Autowired
	private ILigneCommandeClientService ligneCdeService;
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IArticleService articleService;
	
	
	@Autowired
	private ModelCommandeClient modelCommande;
    
	@RequestMapping(value = "/")
	public String index(Model model) {
		List<CommandeClient> commandesClient = commandeService.selectAll();
		if(commandesClient.isEmpty()) {
			commandesClient = new ArrayList<CommandeClient>();
		} else {
			for(CommandeClient commandeClient : commandesClient) {
				List<LigneCommandeClient> ligneCdeClt = ligneCdeService.getByIdCommande(commandeClient.getIdCommandeClient());
				
				commandeClient.setLigneCommandeClients(ligneCdeClt);
			}
		}
		
		model.addAttribute("commandesClient",commandesClient);
		
		return "commandeClient/commandeClient";
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouvelleCommande(Model model) {
		List<Client> clients = clientService.selectAll();
		if(clients.isEmpty()) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients",clients);
		return "commandeClient/nouvelleCommande";
	}
	
	@RequestMapping(value = "/creerCommande")
	public CommandeClient creerCommande(final Long idClient) {
		if(idClient == null) {
			return null;
		}
		Client client = clientService.getById(idClient);
		if(client == null) {
			return null;
		}
		modelCommande.creerCommande(client);
		return modelCommande.getCommande();
	}
	
	@RequestMapping(value = "/ajouterLigne")
	@ResponseBody
	public LigneCommandeClient getArticleByCode(final Long codeArticle) {
		if(codeArticle == null) {
			return null;
		}
		Article article = articleService.findOne("codeArticle", ""+codeArticle);
		if(article == null) {
			return null;
		}
		LigneCommandeClient ligne = modelCommande.ajouterligneCommande(article);
		return ligne;
	}
}
