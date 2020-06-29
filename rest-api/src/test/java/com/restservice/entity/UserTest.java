package com.restservice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {
	
	@Test
	public void createEmptyUserTest() throws Exception {

		User user = new User();
		assertEquals(user.getEmail(), null);
		assertEquals(user.getName(), null);
		assertEquals(user.getLastName(), null);
		assertEquals(user.getBirthDate(), null);
		assertEquals(user.getFilePhoto(), null);
	}
	
	@Test
	public void createUserTest() throws Exception {

		User user = new User(1, "ah@fi.uba.ar", "Agustin", "Horn", "19/09/1990", "picture.png");
		assertEquals(user.getEmail(), "ah@fi.uba.ar");
		assertEquals(user.getName(), "Agustin");
		assertEquals(user.getLastName(), "Horn");
		assertEquals(user.getBirthDate(), "19/09/1990");
		assertEquals(user.getFilePhoto(), "picture.png");
	}

}
