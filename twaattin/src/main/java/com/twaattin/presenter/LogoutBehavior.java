package com.twaattin.presenter;

import java.security.Principal;

import com.twaattin.view.LoginScreen;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

public class LogoutBehavior implements ClickListener {

	private static final long serialVersionUID = -5331651590037516429L;

	@Override
	public void buttonClick(ClickEvent event) {
		
		//UI.getCurrent().addWindow(new CustomDialog());
		VaadinSession.getCurrent().setAttribute(Principal.class, null);
		UI.getCurrent().setContent(new LoginScreen());
		Notification.show("You've been logged out");

	}

}
