package com.stock.gestion.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.gestion.entites.Vente;
import com.stock.gestion.services.IVenteService;
import com.stock.gestion.services.IflickrService;

@Controller
@RequestMapping(value = "/vente")
public class VenteController {
	
	@Autowired
	private IVenteService venteService;
	
	@Autowired
	private IflickrService flickrService;

	@RequestMapping(value = "/")
	public String client(Model model) {
		List<Vente> ventes = venteService.selectAll();
		if(ventes == null) {
			ventes = new ArrayList<Vente>();
		}
		model.addAttribute("ventes",ventes);
		return "vente/vente";
	}
    
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterVente(Model model) {
		Vente vente = new Vente();
		model.addAttribute("vente", vente);
		return "vente/ajouterVente";
	}
	
	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerVente(Model model, Vente vente){
		if(vente != null) {
			if(vente.getIdVente() != null) {
				venteService.update(vente);
			}else {
				venteService.save(vente);
			}	
		}
		return "redirect:/vente/";
	}
	
	@RequestMapping(value = "/modifier/{idVente}")
	public String modifierVente(Model model,@PathVariable Long idVente) {
		if(idVente != null) {
			Vente vente = venteService.getById(idVente);
			if(vente != null) {
				model.addAttribute("vente",vente);
			}
		}
		return "vente/ajouterVente";
	}
	
	@RequestMapping(value = "/supprimer/{idVente}")
	public String suppremerVente(Model model,@PathVariable Long idVente) {
		if(idVente != null) {
			Vente vente = venteService.getById(idVente);
			if(vente != null) {
				//TODO verification avant suppressions
				venteService.remove(idVente);
			}
		}
		return "redirect:/vente/";
	}
}
