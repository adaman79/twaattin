package com.twaattin.view;

import javax.inject.Inject;

import twitter4j.TwitterException;

import com.twaattin.event.LoginEvent;
import com.twaattin.service.TwitterService;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.SystemError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.TextField;

@CDIView
public class LoginScreen extends FormLayout implements ClickListener, View {

	private static final long serialVersionUID = -6898800926708530631L;
	
	@Inject
	private javax.enterprise.event.Event<LoginEvent> eventManager;
	
	private Link twitterLink = new Link();
	private TextField pinField = new TextField();

	private Button submitButton = new Button("Submit");

	public LoginScreen() {

	}

	@Override
	public void enter(ViewChangeEvent event) {
		setMargin(true);
		setSpacing(true);

		twitterLink.setCaption("Get PIN");
		twitterLink.setTargetName("twitterauth");
		try {
			twitterLink.setResource(new ExternalResource(TwitterService.get()
					.getAuthenticationUrl()));
		} catch (TwitterException e) {
			twitterLink.setComponentError(new SystemError(e));
		}

		pinField.setInputPrompt("PIN");
		addComponent(twitterLink);
		addComponent(pinField);
		addComponent(submitButton);

		// submitButton.addClickListener(new LoginBehavior(pinField));
		submitButton.addClickListener(this);

	}

	@Override
	public void buttonClick(ClickEvent event) {
		LoginEvent loginEvent = new LoginEvent(pinField.getValue());
		eventManager.fire(loginEvent);

	}

	public Button getSubmitButton() {
		return submitButton;
	}

}
