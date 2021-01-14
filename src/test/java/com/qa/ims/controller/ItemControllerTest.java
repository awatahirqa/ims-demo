package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private ItemServices itemServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

@Test
	public void readAllTest() {
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>();
		items.add(new Item("Nokia Moon", 599.99));
		items.add(new Item("Samsung Galaxy", 649.99));
		items.add(new Item("Iphone 12", 1200,00));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	public void createTest() {
		String IName = "Iphone 11";
		BigDecimal Price = 1100.00;
		Mockito.doReturn(IName, Price).when(itemController).getInput();
		Item item = new Item(IName, Price);
		Item savedItem = new Item(1L, "Iphone 11", 1100.00);
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}


	 
	@Test
	public void updateTest() {
		String id = "1";
		String IName = "Nokia Sun";
		BigDecimal Price = 699.99;
		Mockito.doReturn(id, IName, Price).when(itemController).getInput();
		Item item= new Item(1L, IName, Price);
		Mockito.when(itemServices.update(item)).thenReturn(item);
		assertEquals(item, itemController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}
}
