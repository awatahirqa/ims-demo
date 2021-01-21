package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private OrderServices orderServices;
	@Spy
	@InjectMocks
	private OrderController orderController;

@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices,null);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L,2,1000));
		orders.add(new Order(2L, 3L,3,3000));
		orders.add(new Order(2L, 5L,4,4000));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}

	@Test
	public void createTest() {
		Long OrderID = 1L;
		Long IDitem = 4L;
		Integer Quantity = 4;
		Integer Cost = 4000;
		Mockito.doReturn(OrderID, IDitem,Quantity,Cost).when(orderController).getInput();
		Order order = new Order(OrderID, IDitem,Quantity,Cost);
		Order savedOrder = new Order(1L, 1L, 4,4000);
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}


	 
	@Test
	public void updateTest() {
		Long OrderID = 1L;
		Long IDitem = 4L;
		Integer Quantity = 4;
		Integer Cost = 4000;
		Mockito.doReturn(OrderID, IDitem,Quantity,Cost).when(orderController).getInput();
		Order order = new Order(1L, 1L, 4,4000);
		Mockito.when(orderServices.update(order)).thenReturn(order);
		assertEquals(order, orderController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
	}
}
