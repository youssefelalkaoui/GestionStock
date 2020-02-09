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

import com.stock.gestion.entites.Utilisateur;
import com.stock.gestion.services.IUtilisateurSerivce;
import com.stock.gestion.services.IflickrService;

@Controller
@RequestMapping(value = "/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private IUtilisateurSerivce utilisateurService;
	
	@Autowired
	private IflickrService flickrService;
	
	@RequestMapping(value = "/")
	public String utilisateur(Model model) {
		List<Utilisateur> utilisateurs = utilisateurService.selectAll();
		if(utilisateurs == null) {
			utilisateurs = new ArrayList<Utilisateur>();
		}
		model.addAttribute("utilisateurs",utilisateurs);
		return "utilisateur/utilisateur";
		
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterUtilisateur(Model model) {
		Utilisateur utilisateur = new Utilisateur();
		model.addAttribute("utilisateur", utilisateur);
		return "utilisateur/ajouterUtilisateur";
	}
	
	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerUtilisateur(Model model, Utilisateur utilisateur, MultipartFile file){
		String photoUrl = null;
		if(utilisateur != null) {
			if(file != null && !file.isEmpty()) {
					InputStream stream = null;
					try {
						stream = file.getInputStream();
						photoUrl = flickrService.savePhoto(stream,utilisateur.getNom());
						utilisateur.setPhoto(photoUrl);
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
			
			if(utilisateur.getIdUtilisateur() != null) {
				utilisateurService.update(utilisateur);
			}else {
				utilisateurService.save(utilisateur);
			}	
		}
		return "redirect:/utilisateur/";
	}
	
	@RequestMapping(value = "/modifier/{idUtilisateur}")
	public String modifierUtilisateur(Model model,@PathVariable Long idUtilisateur) {
		if(idUtilisateur != null) {
			Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
			if(utilisateur != null) {
				model.addAttribute("utilisateur",utilisateur);
			}
		}
		return "utilisateur/ajouterUtilisateur";
	}
	
	@RequestMapping(value = "/supprimer/{idUtilisateur}")
	public String suppremerUtilisateur(Model model,@PathVariable Long idUtilisateur) {
		if(idUtilisateur != null) {
			Utilisateur utilisateur = utilisateurService.getById(idUtilisateur);
			if(utilisateur != null) {
				//TODO verification avant suppressions
				utilisateurService.remove(idUtilisateur);
			}
		}
		return "redirect:/utilisateur/";
	}
	
}
