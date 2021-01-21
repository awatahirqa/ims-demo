package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Order order;
	private Order other;
	
	@Before
	public void setUp() {
		order = new Order(1L, 1L,2,2000);
		other = new Order(1L, 2L,2,2000);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getOrderID());
		assertNotNull(order.getIDitem());
		assertNotNull(order.getQuantity());
		assertNotNull(order.getCost());
		
		order.setOrderID(null);
		assertNull(order.getOrderID());
		order.setIDitem(null);
		assertNull(order.getIDitem());
		order.setQuantity(null);
		assertNull(order.getQuantity());
		order.setCost(null);
		assertNull(order.getCost());
		
		
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createOrderWithId() {
		assertEquals(1L, order.getOrderID(), 0);
		assertEquals(2, order.getQuantity(),0);
		assertEquals(2000, order.getCost(),0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void ItemIDNullButOtherIDNotNull() {
		order.setIDitem(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void IditemNotEqual() {
		other.setIDitem(1L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullIDitem() {
		order.setIDitem(null);
		other.setIDitem(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullOrderId() {
		order.setOrderID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullOrderIdOnBoth() {
		order.setOrderID(null);
		other.setOrderID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIDDifferent() {
		other.setOrderID(4L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullQuantity() {
		order.setQuantity(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullQuantityOnBoth() {
		order.setQuantity(null);
		other.setQuantity(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherQuantityDifferent() {
		other.setQuantity(3);
		assertFalse(order.equals(other));
	}
	@Test
	public void nullCost() {
		order.setCost(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullCostOnBoth() {
		order.setQuantity(null);
		other.setQuantity(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherCostDifferent() {
		other.setQuantity(3);
		assertFalse(order.equals(other));
	}
	
	
	@Test
	public void constructorWithoutOrderId() {
		Order order = new Order(1L, 2,2000);
		assertNotNull(order.getIDitem());
		assertNotNull(order.getQuantity());
		assertNull(order.getCost()); 
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null);
		Order other = new Order(null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String tostring = "Order [ID = 1  , CustomerID = null  ,ItemIDs = 1,"
				+ " quantity = 2 Cost =  2000 ";
		assertEquals(tostring, order.toString());
	}
}
