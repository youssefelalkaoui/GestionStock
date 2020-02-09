package com.stock.gestion.services.impl;

import java.io.InputStream;

import com.stock.gestion.dao.IFlickrDao;
import com.stock.gestion.services.IflickrService;


public class FlickrServiceImpl implements IflickrService{
	
	private IFlickrDao dao;
	
	
	public void setDao(IFlickrDao dao) {
		this.dao = dao;
	}

    @Override
	public String savePhoto(InputStream photo, String title) throws Exception {
		return dao.savePhoto(photo,title);
	}

}
