package com.qa.ims.persistence.domain;

public class OrderLine {
	private Long orderID;
	private Long itemID;
	private Long quantity;
	
	public OrderLine(Long orderID, Long itemID, Long quantity) {
		this.orderID = orderID;
		this.itemID = itemID;
		this.quantity = quantity;		
	}
	
	
	public Long getOrderID() {
		return orderID;
	}
	public void setOrderID(Long orderid) {
		this.orderID = orderid;
	}
	public Long getItemID() {
		return itemID;
	}
	public void setItemID(Long itemid) {
		this.itemID = itemid;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "order ID" + orderID + "item ID" + itemID + "quantity" + quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLine other = (OrderLine) obj;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID)) 
			return false;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID)) 
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity)) 
			return false;
		return true;
	
	}	
}
