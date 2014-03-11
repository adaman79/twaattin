package com.twaattin.decorator;

import twitter4j.User;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;


public class ScreenColumnGenerator extends AbstractUserColumnGenerator {
	
	private static final long serialVersionUID = -3701626347844019034L;
	private static final String TWITTER_USER_URL = "https://twitter.com";

	@Override
	public Object generateCell(Table source, Object itemId, Object columnId) {
		User user = getUser(source, itemId);
		
		ExternalResource externalResource = new ExternalResource(TWITTER_USER_URL + user.getScreenName());
		Link link = new Link('@' + user.getScreenName() , externalResource);
		link.setTargetName("screenname");
		return link;
	}

}
