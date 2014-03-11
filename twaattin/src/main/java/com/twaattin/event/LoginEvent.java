package com.twaattin.event;

public class LoginEvent {
	private final String pinValue;

	public LoginEvent(String pinValue) {
		super();
		this.pinValue = pinValue;
	}

	public String getPinValue() {
		return pinValue;
	}
}
