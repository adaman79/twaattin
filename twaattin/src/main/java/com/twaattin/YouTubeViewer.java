package com.twaattin;

import com.twaattin.client.YouTubeViewerState;
import com.vaadin.ui.AbstractComponent;

public class YouTubeViewer extends AbstractComponent{

	private static final long serialVersionUID = 1656717323699251796L;
	
	public YouTubeViewer() {}
	
	public YouTubeViewer(String movieId) {
		setMovieId(movieId);
	}
	
	@Override
	protected YouTubeViewerState getState() {
		return (YouTubeViewerState) super.getState();
	}
	
	public void setMovieId(String movieId) {
		getState().setMovieId(movieId);
	}

}
