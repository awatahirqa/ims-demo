package com.qa.ims.persistence.domain;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	private Item item;
	private Item other;
	
	@Before
	public void setUp() {
		item = new Item(1L, "Samsung Galaxy S6", 899.99);
		other = new Item(1L, "Nokia G13", 649.99);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getIName());
		assertNotNull(item.getPrice());
		
		item.setId(null);
		assertNull(item.getId());
		item.setIName(null);
		assertNull(item.getIName());
		item.setPrice(null);
		assertNull(item.getPrice());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, item.getId(), 0);
		assertEquals("Samsung Galaxy S6", item.getIName());
		assertEquals(899.99, item.getPrice());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(item.equals(item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(item.equals(other));
	}
	
	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setIName(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void itemNamesNotEqual() {
		other.setIName("rhys");
		assertFalse(item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setIName(null);
		other.setIName(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void nullId() {
		item.setId(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		item.setId(null);
		other.setId(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullPrice() {
		item.setPrice(null);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void nullPriceOnBoth() {
		item.setPrice(null);
		other.setPrice(null);
		assertTrue(item.equals(other));
	}
	
	@Test
	public void otherPriceDifferent() {
		other.setPrice(750.89);
		assertFalse(item.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Item item = new Item("Samsung Galaxy S6", 899.99);
		assertNull(item.getId());
		assertNotNull(item.getIName());
		assertNotNull(item.getPrice());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(item.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Item item = new Item(null, null);
		Item other = new Item(null, null);
		assertEquals(item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "id:1 item name:Samsung Galaxy S6 price:" + 899.99;
		assertEquals(toString, item.toString());
	}
}
