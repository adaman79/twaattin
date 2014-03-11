package com.twaattin.view;

import java.security.Principal;
import java.util.Locale;

import twitter4j.Status;

import com.twaattin.TwaattinUI;
import com.twaattin.decorator.NameColumnGenerator;
import com.twaattin.decorator.ProfileImageColumnGenerator;
import com.twaattin.decorator.ScreenColumnGenerator;
import com.twaattin.decorator.SourceColumnDecorator;
import com.twaattin.decorator.TweetColumnDecorator;
import com.twaattin.presenter.LogoutBehavior;
import com.twaattin.presenter.TweetRefresherBehavior;
import com.vaadin.cdi.CDIView;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

@CDIView(value = TimelineScreen.VIEW_ID)
public class TimelineScreen extends VerticalLayout implements View {
	
	public static final String VIEW_ID = "timeline";

	private static final long serialVersionUID = 3794893732517117411L;

	public TimelineScreen() {
	}

	private void setUpTable(Table table) {
		table.addGeneratedColumn("source", new SourceColumnDecorator());
		table.addGeneratedColumn("screenName", new ScreenColumnGenerator());
		table.addGeneratedColumn("name", new NameColumnGenerator());
		table.addGeneratedColumn("profileImage",
				new ProfileImageColumnGenerator());
		table.addGeneratedColumn("text", new TweetColumnDecorator());

		table.setColumnHeader("source", "via");
		table.setColumnHeader("screenName", "Screen Name");
		table.setColumnHeader("profileImage", "");
		table.setColumnHeader("text", "Tweet");
		table.setVisibleColumns(new Object[] { "text", "name", "screenName",
				"profileImage", "createdAt", "source" });
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("You're authenticated into Twaattin");
		setMargin(true);
		Label label = new Label(VaadinSession.getCurrent()
				.getAttribute(Principal.class).getName());
		Button button = new Button("Logout");
		button.addClickListener(new LogoutBehavior());
		HorizontalLayout menuBar = new HorizontalLayout(label, button);
		menuBar.setWidth(100, Unit.PERCENTAGE);
		menuBar.setComponentAlignment(button, Alignment.MIDDLE_RIGHT);

		addComponent(menuBar);
		TweetRefresherBehavior behavior = TwaattinUI.getCurrent().getTweetRefresherBehavior();
		addComponentAttachListener(behavior);

		Table table = new Table();
		
		BeanContainer<Long, Status> container = new BeanContainer<Long, Status>(Status.class);

		table.setContainerDataSource(container);
		container.setBeanIdProperty("id");
		table.setLocale(Locale.ENGLISH);

		addComponent(table);

		setUpTable(table);
		
	}
}
