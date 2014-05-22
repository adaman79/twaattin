package com.twaattin.view;

import com.twaattin.model.StatusDto;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;

public class StatusComponent extends CustomComponent {

	private static final long serialVersionUID = -2060209501255178533L;

	public StatusComponent(StatusDto statusDto) {
		ExternalResource userPage = new ExternalResource(
				StatusConverter.TWITTER_USER_URL + statusDto.getScreenName());

		Link name = new Link(statusDto.getName(), userPage);

		Label screenName = new Label('@' + statusDto.getScreenName());

		HorizontalLayout names = new HorizontalLayout(name, screenName);
		names.setSpacing(true);

		Label tweet = new Label(statusDto.getTweet(), ContentMode.HTML);

		HorizontalLayout actionsBar = new HorizontalLayout(new Button("Reply"),
				new Button("Retweet"), new Button("Favorite"));
		
		actionsBar.setSpacing(true);
		
		String retweetedBy = statusDto.getRetweetedBy();
		
		VerticalLayout rightSide;
		
		if(retweetedBy == null) {
			rightSide = new VerticalLayout(names, tweet, actionsBar);
		} else {
			Label label = new Label("Retweeted by " + retweetedBy, ContentMode.HTML);
			rightSide = new VerticalLayout(names, tweet, label, actionsBar);
		}
		
		rightSide.setSpacing(true);
		
		Resource picturesResource = new ExternalResource(statusDto.getProfileImage());
		
		Image picture = new Image(null, picturesResource);
		
		picture.setHeight(50, Unit.PIXELS);
		picture.setWidth(50, Unit.PIXELS);
		
		HorizontalLayout mainLayout = new HorizontalLayout(picture, rightSide);
		
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		
		setCompositionRoot(mainLayout);
	}

}
