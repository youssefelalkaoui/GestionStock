package com.stock.gestion.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.gestion.dao.IMvStkDao;
import com.stock.gestion.entites.MvStk;
import com.stock.gestion.services.IMvStkService;


@Transactional
public class MvStkServiceImpl implements IMvStkService{
	
	private IMvStkDao dao;
	
	
	public void setDao(IMvStkDao dao) {
		this.dao = dao;
	}

	@Override
	public MvStk save(MvStk entity) {
		return dao.save(entity);
	}

	@Override
	public MvStk update(MvStk entity) {
		return dao.update(entity);
	}

	@Override
	public List<MvStk> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<MvStk> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField,sort);
	}

	@Override
	public MvStk getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public MvStk findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName,paramValue);
	}

	@Override
	public MvStk findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames,paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return findCountBy(paramName,paramValue);
	}

}
