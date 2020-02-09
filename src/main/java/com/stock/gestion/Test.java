package com.stock.gestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.stock.gestion.dao.impl.FlickrDaoImpl;
import com.stock.gestion.services.impl.FlickrServiceImpl;



public class Test {

	public static void main(String[] args) {
		FlickrDaoImpl flickr = new FlickrDaoImpl();
        //flickr.auth();
		
		try {
			InputStream stream = new FileInputStream(new File("/Users/youssefelalkaoui/Desktop/javaEE.png"));
			String url = flickr.savePhoto(stream,"myImage");
			System.out.println(url);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
