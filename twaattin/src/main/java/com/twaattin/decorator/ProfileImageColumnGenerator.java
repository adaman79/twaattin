package com.twaattin.decorator;

import twitter4j.User;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.Table;

public class ProfileImageColumnGenerator extends AbstractUserColumnGenerator {

	private static final long serialVersionUID = 7704188232336655904L;

	@Override
	public Object generateCell(Table source, Object itemId, Object columnId) {
		User user = getUser(source, itemId);
		String url = user.getMiniProfileImageURL();
		
		if(url != null) {
			ExternalResource resource = new ExternalResource(url);
			
			return new Image("", resource);
		}
		return null;
	}

}
