package com.stock.gestion.dao.impl;

import java.io.InputStream;

import javax.swing.JOptionPane;

import org.scribe.model.Token;
import org.scribe.model.Verifier;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.stock.gestion.dao.IFlickrDao;

public class FlickrDaoImpl implements IFlickrDao{
	
	private Flickr flickr;
	
	private UploadMetaData uploadMetaData = new UploadMetaData();
	
	private String apiKey = "f667066bf81f1e041c754c9335791875";
	
	private String sharedSecret = "90dfa2602d318264";
	
	private void connect() {
		flickr = new Flickr(apiKey,sharedSecret,new REST());
		Auth auth = new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("72157679540460878-57fb9e5203c6698c");
		auth.setTokenSecret("e9ed4b480ae996e8");
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
	}
	
	@Override
	public String savePhoto(InputStream photo, String title) throws Exception{
		connect();
		uploadMetaData.setTitle(title);
		String photoId = flickr.getUploader().upload(photo,uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}
	
	public void auth() {
		flickr = new Flickr(apiKey,sharedSecret,new REST());
		
		AuthInterface authInterface = flickr.getAuthInterface();
		
		Token token = authInterface.getRequestToken();
		System.out.println("token: " + token);
		
		String url = authInterface.getAuthorizationUrl(token,Permission.DELETE);
		System.out.println("Follow this URL to authorise yourself on Flickr");
		System.out.println(url);
		System.out.println("Paste in the token it gives you :");
		System.out.println(">>");
		
		String tokenKey = JOptionPane.showInputDialog(null);
		
		Token requestToken = authInterface.getAccessToken(token,new Verifier(tokenKey));
		System.out.println("Authentication sucess");
		
		Auth auth = null;
		try {
			auth = authInterface.checkToken(requestToken);
		} catch(FlickrException e) {
			e.printStackTrace();
		}
		
		// This token can be used until the user revokes it.
		System.out.println("Token: " + requestToken.getToken());
		System.out.println("Secret: " + requestToken.getSecret());
		System.out.println("nsid: " + auth.getUser().getId());
		System.out.println("Realname: " + auth.getUser().getRealName());
		System.out.println("Username: " + auth.getUser().getUsername());
		
	}

}
