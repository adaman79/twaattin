package com.twaattin.presenter;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.twaattin.TwaattinUITest;
import com.twaattin.event.LoginEvent;

public class LoginBehaviorTest extends TwaattinUITest{

	LoginBehavior loginBehavior;

	@Test
	public void handleLogin() {
		loginBehavior = (LoginBehavior) getUi().getViewProvider().getView("LoginBehavior");
		LoginEvent loginEvent = Mockito.mock(LoginEvent.class);
		loginBehavior.handleLogin(loginEvent);
	}
}
