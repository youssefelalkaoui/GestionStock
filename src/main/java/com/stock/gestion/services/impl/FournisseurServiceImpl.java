package com.stock.gestion.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.gestion.dao.IFournisseurDao;
import com.stock.gestion.entites.Fournisseur;
import com.stock.gestion.services.IFournisseurService;


@Transactional
public class FournisseurServiceImpl implements IFournisseurService{
	
	private IFournisseurDao dao;
	
	

	public void setDao(IFournisseurDao dao) {
		this.dao = dao;
	}

	@Override
	public Fournisseur save(Fournisseur entity) {
		return dao.save(entity);
	}

	@Override
	public Fournisseur update(Fournisseur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Fournisseur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Fournisseur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField,sort);
	}

	@Override
	public Fournisseur getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Fournisseur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName,paramValue);
	}

	@Override
	public Fournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames,paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return findCountBy(paramName,paramValue);
	}

}
