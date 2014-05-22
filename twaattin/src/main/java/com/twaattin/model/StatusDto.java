package com.twaattin.model;

public class StatusDto {

	private String name;
	private String screenName;
	private String profileImage;
	private String tweet;
	private String retweetedBy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	public String getRetweetedBy() {
		return retweetedBy;
	}
	public void setRetweetedBy(String retweetedBy) {
		this.retweetedBy = retweetedBy;
	}
	
	
}
