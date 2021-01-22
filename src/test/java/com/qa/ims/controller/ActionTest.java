package com.qa.ims.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ActionTest {
	@Test
	public void CREATETest() {
		Action action = Action.CREATE;
		assertTrue(action.getDescription().toLowerCase().contains("create"));
	}
	
	@Test
	public void ReadTest() {
		Action action = Action.READ;
		assertTrue(action.getDescription().toLowerCase().contains("read"));
	}


	
	@Test
	public void UpdateTest() {
		Action action = Action.UPDATE;
		assertTrue(action.getDescription().toLowerCase().contains("update"));
	}
	
	@Test
	public void DeleteTest() {
		Action action = Action.DELETE;
		assertTrue(action.getDescription().toLowerCase().contains("delete"));
	}
	
	@Test
	public void ReturnTest() {
		Action action = Action.RETURN;
		assertTrue(action.getDescription().toLowerCase().contains("return"));
	}

}
