package com.twaattin.presenter;

import java.security.Principal;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.twaattin.authentication.AuthenticationException;
import com.twaattin.authentication.TwitterAuthenticationStrategy;
import com.twaattin.event.LoginEvent;
import com.twaattin.view.LoginScreen;
import com.twaattin.view.TimelineScreen;
import com.vaadin.server.SystemError;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class LoginBehavior {

	private static final long serialVersionUID = 2981452401271943814L;
	
	@Inject
	LoginScreen loginScreen;
	
	public void handleLogin(@Observes LoginEvent event) {
		try {
			String pin = event.getPinValue();
			
			Principal user = new TwitterAuthenticationStrategy().authenticate(pin);
			VaadinSession.getCurrent().setAttribute(Principal.class, user);
			UI.getCurrent().getNavigator().navigateTo(TimelineScreen.VIEW_ID);
			
			//UI.getCurrent().setContent(new TimelineScreen());
			Notification.show("You're authenticated into Twaattin");
		} catch (AuthenticationException e) {
			UI.getCurrent().setComponentError(new SystemError(e));
		}
	}

}
