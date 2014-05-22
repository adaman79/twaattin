package com.twaattin.client;

import com.google.gwt.user.client.ui.Widget;
import com.twaattin.YouTubeViewer;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(YouTubeViewer.class)
public class YouTubeViewerConnector extends AbstractComponentConnector{

	private static final long serialVersionUID = -1269650718310991305L;
	
	@Override
	public YouTubeViewerState getState() {
		return (YouTubeViewerState) super.getState();
	}
	
	@Override
	public com.google.gwt.widgetideas.client.YouTubeViewer getWidget() {
		return (com.google.gwt.widgetideas.client.YouTubeViewer) super.getWidget();
	}
	
	@Override
	protected Widget createWidget() {
		return new com.google.gwt.widgetideas.client.YouTubeViewer("");
	}
	
	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
		
		String movieId = getState().getMovieId();
		
		getWidget().setMovieID(movieId);
	}

}
