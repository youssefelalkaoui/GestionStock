package com.stock.gestion.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.stock.gestion.entites.Fournisseur;
import com.stock.gestion.services.IFournisseurService;
import com.stock.gestion.services.IflickrService;

@Controller
@RequestMapping(value = "/fournisseur")
public class FournisseurController {

	@Autowired
	private IFournisseurService fournisseurService;
	
	@Autowired
	private IflickrService flickrService;

	@RequestMapping(value = "/")
	public String client(Model model) {
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if(fournisseurs == null) {
			fournisseurs = new ArrayList<Fournisseur>();
		}
		model.addAttribute("fournisseurs",fournisseurs);
		return "fournisseur/fournisseur";
		
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterFournisseur(Model model) {
		Fournisseur fournisseur = new Fournisseur();
		model.addAttribute("fournisseur", fournisseur);
		return "fournisseur/ajouterFournisseur";
	}
	
	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerFournisseur(Model model, Fournisseur fournisseur, MultipartFile file){
		String photoUrl = null;
		if(fournisseur != null) {
			if(file != null && !file.isEmpty()) {
					InputStream stream = null;
					try {
						stream = file.getInputStream();
						photoUrl = flickrService.savePhoto(stream,fournisseur.getNom());
						fournisseur.setPhoto(photoUrl);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						try {
							stream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
			
			if(fournisseur.getIdFournisseur() != null) {
				fournisseurService.update(fournisseur);
			}else {
				fournisseurService.save(fournisseur);
			}	
		}
		return "redirect:/fournisseur/";
	}
	
	@RequestMapping(value = "/modifier/{idFournisseur}")
	public String modifierFournisseur(Model model,@PathVariable Long idFournisseur) {
		if(idFournisseur != null) {
			Fournisseur fournisseur = fournisseurService.getById(idFournisseur);
			if(fournisseur != null) {
				model.addAttribute("fournisseur",fournisseur);
			}
		}
		return "fournisseur/ajouterFournisseur";
	}
	
	@RequestMapping(value = "/supprimer/{idFournisseur}")
	public String suppremerFournisseur(Model model,@PathVariable Long idFournisseur) {
		if(idFournisseur != null) {
			Fournisseur fournisseur = fournisseurService.getById(idFournisseur);
			if(fournisseur != null) {
				//TODO verification avant suppressions
				fournisseurService.remove(idFournisseur);
			}
		}
		return "redirect:/fournisseur/";
	}
}
