package com.qa.ims.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderActionTest {
	@Test
	public void CREATETest() {
		OrderAction action = OrderAction.CREATE;
		assertTrue(action.getDescription().toLowerCase().contains("create"));
	}
	
	@Test
	public void ReadTest() {
		OrderAction action = OrderAction.READ;
		assertTrue(action.getDescription().toLowerCase().contains("read"));
	}


	
	@Test
	public void UpdateTest() {
		OrderAction action = OrderAction.UPDATE;
		assertTrue(action.getDescription().toLowerCase().contains("update"));
	}
	
	@Test
	public void DeleteTest() {
		OrderAction action = OrderAction.DELETE;
		assertTrue(action.getDescription().toLowerCase().contains("delete"));
	}
	
	@Test
	public void ReturnTest() {
		OrderAction action = OrderAction.RETURN;
		assertTrue(action.getDescription().toLowerCase().contains("return"));
	}
}
