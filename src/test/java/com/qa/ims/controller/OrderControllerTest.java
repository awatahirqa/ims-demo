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
		OrderController orderController = new OrderController(orderServices);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L));
		orders.add(new Order(2L, 3L));
		orders.add(new Order(2L, 5L));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}

	@Test
	public void createTest() {
		Long CustomerID = 1L;
		Long OrderLineID = 4L;
		Mockito.doReturn(CustomerID, OrderLineID).when(orderController).getInput();
		Order order = new Order(CustomerID, OrderLineID);
		Order savedOrder = new Order(1L, 1L, 4L);
		Mockito.when(orderServices.create(order)).thenReturn(savedOrder);
		assertEquals(savedOrder, orderController.create());
	}


	 
	@Test
	public void updateTest() {
		String id = "1";
		Long CustomerID = 2L;
		Long OrderLineID = 7L;
		Mockito.doReturn(id, CustomerID, OrderLineID).when(orderController).getInput();
		Order order = new Order(1L, CustomerID, OrderLineID);
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
