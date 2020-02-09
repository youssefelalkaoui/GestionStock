package com.stock.gestion.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.gestion.dao.ILigneVenteDao;
import com.stock.gestion.entites.LigneVente;
import com.stock.gestion.services.ILigneVenteService;

@Transactional
public class LigneVenteServiceImpl implements ILigneVenteService{
	
	private ILigneVenteDao dao;
	

	public void setDao(ILigneVenteDao dao) {
		this.dao = dao;
	}

	@Override
	public LigneVente save(LigneVente entity) {
		return dao.save(entity);
	}

	@Override
	public LigneVente update(LigneVente entity) {
		return dao.update(entity);
	}

	@Override
	public List<LigneVente> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<LigneVente> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField,sort);
	}

	@Override
	public LigneVente getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public LigneVente findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName,paramValue);
	}

	@Override
	public LigneVente findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames,paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return findCountBy(paramName,paramValue);
	}

}
