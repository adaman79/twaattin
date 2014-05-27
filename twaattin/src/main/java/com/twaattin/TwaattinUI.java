package com.twaattin;

import javax.inject.Inject;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import twitter4j.DirectMessage;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.UserStreamListener;

import com.twaattin.presenter.TweetRefresherBehavior;
import com.twaattin.view.LoginScreen;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.SystemError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Title("Twitter Vaadin example")
@Theme("mytheme")
@Push
@CDIUI
public class TwaattinUI extends UI implements UserStreamListener {

	private static final long serialVersionUID = -7018348464221743334L;

	@Inject
	private CDIViewProvider viewProvider;

	public CDIViewProvider getViewProvider() {
		return viewProvider;
	}

	String disabledLabel;

	public String getDisabledLabel() {
		return disabledLabel;
	}

	@WebServlet(value = "/*", asyncSupported = true, initParams = { @WebInitParam(name = "UIProvider", value = "com.vaadin.cdi.CDIUIProvider") })
	@VaadinServletConfiguration(productionMode = false, ui = TwaattinUI.class, widgetset = "com.twaattin.IncubatorWidgetset")
	public static class Servlet extends VaadinServlet {

		private static final long serialVersionUID = -5422929630391151245L;

	}

	private TweetRefresherBehavior tweetRefresherBehavior = new TweetRefresherBehavior();

	public TweetRefresherBehavior getTweetRefresherBehavior() {
		return tweetRefresherBehavior;
	}

	public static TwaattinUI getCurrent() {

		return (TwaattinUI) UI.getCurrent();
	}

	@Override
	protected void init(VaadinRequest request) {
		/*
		 * YouTube Widget example
		 * 
		 * final YouTubeViewer viewer = new YouTubeViewer("yWrkinZkKjI");
		 * 
		 * TextField field = new TextField("Movie ID:", "yWrkinZkKjI");
		 * 
		 * field.setImmediate(true);
		 * 
		 * field.addValueChangeListener(new ValueChangeListener() {
		 * 
		 * @Override public void valueChange(ValueChangeEvent event) {
		 * 
		 * String movieId = (String) event.getProperty().getValue();
		 * 
		 * viewer.setMovieId(movieId); } });
		 * 
		 * VerticalLayout layout = new VerticalLayout(viewer, field);
		 * 
		 * layout.setSpacing(true); layout.setMargin(true);
		 * 
		 * setContent(layout);
		 */

		/*
		 * WidgetSet Extension
		 * 
		 * disabledLabel = request.getParameter("label");
		 * 
		 * final Button submitButton = new Button("Submit");
		 * 
		 * new DisableOnClickButtonExtension( disabledLabel == null ?
		 * "Please wait..." : "Some other")//disabledLabel)
		 * .extend(submitButton);
		 * 
		 * Button queryButton = new Button("Query");
		 * 
		 * queryButton.addClickListener(new ClickListener() {
		 * 
		 * @Override public void buttonClick(ClickEvent event) {
		 * 
		 * Notification.show("Enabled: " + submitButton.isEnabled()); } });
		 * 
		 * HorizontalLayout layout = new HorizontalLayout(submitButton,
		 * queryButton);
		 * 
		 * layout.setSpacing(true); layout.setMargin(true);
		 * 
		 * setContent(layout);
		 */

		setSizeFull();
		Navigator navigator = new Navigator(this, this);
		navigator.addProvider(viewProvider);
		setContent(new LoginScreen());

	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatus(final Status status) {
		access(new Runnable() {

			@Override
			public void run() {
				tweetRefresherBehavior.updatedStatus(status);

			}
		});

	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onException(Exception arg0) {
		setComponentError(new SystemError(arg0));

	}

	@Override
	public void onBlock(User arg0, User arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDeletionNotice(long arg0, long arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDirectMessage(DirectMessage arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFavorite(User arg0, User arg1, Status arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFollow(User arg0, User arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFriendList(long[] arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnblock(User arg0, User arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnfavorite(User arg0, User arg1, Status arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserListCreation(User arg0, UserList arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserListDeletion(User arg0, UserList arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserListMemberAddition(User arg0, User arg1, UserList arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserListMemberDeletion(User arg0, User arg1, UserList arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserListSubscription(User arg0, User arg1, UserList arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserListUnsubscription(User arg0, User arg1, UserList arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserListUpdate(User arg0, UserList arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUserProfileUpdate(User arg0) {
		// TODO Auto-generated method stub

	}

}
