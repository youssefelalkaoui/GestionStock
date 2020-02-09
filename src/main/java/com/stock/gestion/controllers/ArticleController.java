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

import com.stock.gestion.entites.Article;
import com.stock.gestion.entites.Category;
import com.stock.gestion.services.IArticleService;
import com.stock.gestion.services.ICategoryService;
import com.stock.gestion.services.IflickrService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IflickrService flickrService;

	@RequestMapping(value = "/")
	public String article(Model model) {
		List<Article> articles = articleService.selectAll();
		if(articles == null) {
			articles = new ArrayList<Article>();
		}
		model.addAttribute("articles",articles);
		return "article/article";
		
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterarticle(Model model) {
		Article article = new Article();
		List<Category> categories = categoryService.selectAll();
		if (categories == null) {
			categories = new ArrayList<Category>();
		}
		model.addAttribute("article", article);
		model.addAttribute("categories", categories);
		return "article/ajouterArticle";
	}
	
	
	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerArticle(Model model, Article article, MultipartFile file){
		String photoUrl = null;
		if(article != null) {
			if(file != null && !file.isEmpty()) {
					InputStream stream = null;
					try {
						stream = file.getInputStream();
						photoUrl = flickrService.savePhoto(stream,article.getDesignation());
						article.setPhoto(photoUrl);
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
			
			if(article.getIdArticle() != 0) {
				articleService.update(article);
			}else {
				articleService.save(article);
			}	
		}
		return "redirect:/article/";
	}
	
	@RequestMapping(value = "/modifier/{idArticle}")
	public String modifierArticle(Model model,@PathVariable Long idArticle) {
		if(idArticle != null) {
			Article article = articleService.getById(idArticle);
			List<Category> categories = categoryService.selectAll();
			if (categories == null) {
				categories = new ArrayList<Category>();
			}
			model.addAttribute("categories", categories);
			if(article != null) {
				model.addAttribute("article",article);
			}
		}
		return "article/ajouterArticle";
	}
	
	@RequestMapping(value = "/supprimer/{idArticle}")
	public String suppremerArticle(Model model,@PathVariable Long idArticle) {
		if(idArticle != null) {
			Article article = articleService.getById(idArticle);
			if(article != null) {
				//TODO verification avant suppressions
				articleService.remove(idArticle);
			}
		}
		return "redirect:/article/";
	}
	
}
