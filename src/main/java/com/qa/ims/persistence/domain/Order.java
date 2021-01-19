package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	//Order Attributes
	private Long OrderID;
	private Long CustomerID;
	//OrderLine Attributes
	private List<Long> ItemIDs = new ArrayList<>();
	private Long Quantity;

	public Order(Long CustomerID,List<Long> ItemIDs,Long Quantity) {
		this.CustomerID = CustomerID;
		this.ItemIDs = ItemIDs;
		this.Quantity = Quantity;
	}

	public Order(Long ID, Long CustomerID,Long Quantity,List<Long> ItemIDs) {
		this.OrderID = ID;
		this.CustomerID = CustomerID;
		this.Quantity = Quantity;
		this.ItemIDs = ItemIDs;
		
	}
	//Order Constructor 
	public Order(Long CustomerID, Long OrderLineID) {
		this.CustomerID = CustomerID;
		
		
	}
	public Order(Long ID, Long CustomerID, Long OrderLineID) {
		this.OrderID = ID;
		this.CustomerID = CustomerID;
		
		
	}
	//OrderLine Constructor
	public Order( Long OrderID,Long Quantity,List<Long> ItemIDs) {
		this.OrderID = OrderID;
		this.Quantity = Quantity;
		this.ItemIDs = ItemIDs;
		
	}
	
	public Long getID() {
		return OrderID;
	}

	public void setID(Long ID) {
		this.OrderID = ID;
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long CustomerID) {
		this.CustomerID = CustomerID;
	}

	

	public List<Long> getItemID() {
		return ItemIDs;
	}

	public void setItemID(List<Long> ItemIDs) {
		this.ItemIDs = ItemIDs;
	}

	public Long getQuantity() {
		return Quantity;
	}

	public void setQuantity(Long Quantity) {
		this.Quantity = Quantity;
	}

	
	@Override
	public String toString() {
		return "Order [ID =" + OrderID + ", CustomerID =" + CustomerID + ","  + ", ItemIDs =" + ItemIDs
				+ ", quantity =" + Quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CustomerID == null) ? 0 : CustomerID.hashCode());
		result = prime * result + ((OrderID == null) ? 0 : OrderID.hashCode());
		result = prime * result + ((ItemIDs == null) ? 0 : ItemIDs.hashCode());
		result = prime * result + ((Quantity == null) ? 0 : Quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (CustomerID == null) {
			if (other.CustomerID != null)
				return false;
		} else if (!CustomerID.equals(other.CustomerID))
			return false;
		if (OrderID == null) {
			if (other.OrderID != null)
				return false;
		} else if (!OrderID.equals(other.OrderID))
			return false;
		
		if (ItemIDs == null) {
			if (other.ItemIDs != null)
				return false;
		} else if (!ItemIDs.equals(other.ItemIDs))
			return false;
		if (Quantity == null) {
			if (other.Quantity != null)
				return false;
		} else if (!Quantity.equals(other.Quantity))
			return false;
		return true;
	}

}

