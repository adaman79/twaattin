package com.twaattin.client;

import com.vaadin.shared.AbstractComponentState;

public class YouTubeViewerState extends AbstractComponentState{

	private static final long serialVersionUID = -4923508553865380616L;
	
	private String movieId;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
}
