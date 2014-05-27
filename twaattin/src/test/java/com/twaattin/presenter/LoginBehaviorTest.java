package com.twaattin.presenter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.twaattin.TwaattinUI;

public class LoginBehaviorTest {

	TwaattinUI ui;

	@BeforeTest
	public void init() {
		ui = new TwaattinUI();
	}

	@Test
	public void handleLogin() {
		throw new RuntimeException("Test not implemented");
	}
}
