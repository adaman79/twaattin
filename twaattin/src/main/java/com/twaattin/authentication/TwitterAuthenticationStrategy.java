package com.twaattin.authentication;

import java.security.Principal;

import twitter4j.TwitterException;

import com.twaattin.service.TwitterService;

public class TwitterAuthenticationStrategy implements PinAuthenticationStrategy {

	@Override
	public Principal authenticate(String pin) throws AuthenticationException {

		try {

			String screenName = TwitterService.get().authenticate(pin);

			return new User(screenName);

		} catch (TwitterException e) {

			throw new AuthenticationException(e);
		}
	}
}
