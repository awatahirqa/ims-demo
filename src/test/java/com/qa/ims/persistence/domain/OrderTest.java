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
		order = new Order(1L, 1, 1);
		other = new Order(1L, 2, 2);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getId());
		assertNotNull(order.getCustomerID());
		assertNotNull(order.getOrderLineID());
		
		order.setId(null);
		assertNull(order.getId());
		order.setCustomerID(null);
		assertNull(order.getCustomerID());
		order.setOrderLineID(null);
		assertNull(order.getOrderLineID());
		
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
		assertEquals(1L, order.getId(), 0);
		assertEquals((long)1, order.getCustomerID());
		assertEquals((long)1, order.getOrderLineID());
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
	public void customerIDNullButOtherIDNotNull() {
		order.setCustomerID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void customerIDsNotEqual() {
		other.setCustomerID((long) 3);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullCustomerID() {
		order.setCustomerID(null);
		other.setCustomerID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullId() {
		order.setId(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		order.setId(null);
		other.setId(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullOrderLineID() {
		order.setOrderLineID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullOrderLineIDOnBoth() {
		order.setOrderLineID(null);
		other.setOrderLineID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherOrderLineIDDifferent() {
		other.setOrderLineID((long) 3);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Order order = new Order(1, 1);
		assertNull(order.getId());
		assertNotNull(order.getCustomerID());
		assertNotNull(order.getOrderLineID());
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
		String toString = "id:1 CustomerID" + 1 + "OrderLineID" + 1;
		assertEquals(toString, order.toString());
	}
}
