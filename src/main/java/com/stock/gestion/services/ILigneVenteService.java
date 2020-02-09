package com.stock.gestion.services;

import java.util.List;

import com.stock.gestion.entites.LigneVente;



public interface ILigneVenteService {
	
    public LigneVente save(LigneVente entity);
	
	public LigneVente update(LigneVente entity);
	
	public List<LigneVente> selectAll();
	
	public List<LigneVente> selectAll(String sortField,String sort);
	
	public LigneVente getById(Long id);
	
	public void remove(Long id);
	
	public LigneVente findOne(String paramName , Object paramValue);
	
	public LigneVente findOne(String[] paramNames , Object[] paramValues);
	
	public int findCountBy(String paramName , String paramValue);
	
} 
