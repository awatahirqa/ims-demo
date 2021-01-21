package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	//Order Attributes
	private Long OrderID;
	private Long CustomerID;
	private Integer Cost;
	//OrderLine Attributes
	private ArrayList<Item> ItemIDs = new ArrayList<>();
	private Integer Quantity;
	private Item itemIDs ;
	private Long IDitem;

	

	public Order(Long orderID, Long iDitem , Integer quantity, Integer cost ) {
		super();
		OrderID = orderID;
		IDitem = iDitem;
		Quantity = quantity;
		Cost = cost;
		
		
	}
	public Order( Long iDitem , Integer quantity, Integer cost ) {
		super();
		IDitem = iDitem;
		Quantity = quantity;
		Cost = cost;
		
		
	}

	public Order(Long CustomerID,ArrayList<Item> ItemIDs,Integer Quantity) {
		this.CustomerID = CustomerID;
		this.ItemIDs = ItemIDs;
		this.Quantity = Quantity;
	}

	public Order(Long OrderID, Long CustomerID,Integer Cost,Integer Quantity,ArrayList<Item> ItemIDs) {
		this.OrderID = OrderID;
		this.CustomerID = CustomerID;
		this.Cost = Cost;
		this.Quantity = Quantity;
		this.ItemIDs = ItemIDs;
		
	}
	//Order Constructor 
	public Order(Long CustomerID) {
		this.CustomerID = CustomerID;
		
		
	}
	public Order(Long OrderID, Long CustomerID) {
		this.OrderID = OrderID;
		this.CustomerID = CustomerID;
		
		
	}
	//OrderLine Constructor
	public Order( Long OrderID,Integer Quantity,ArrayList<Item> ItemIDs) {
		this.OrderID = OrderID;
		this.Quantity = Quantity;
		this.ItemIDs = ItemIDs;
		
	}
	
	public Long getOrderID() {
		return OrderID;
	}

	public void setOrderID(Long ID) {
		this.OrderID = ID;
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long CustomerID) {
		this.CustomerID = CustomerID;
	}

	public ArrayList<Item> getItemID() {
		return ItemIDs;
	}

	public void setItemID(ArrayList<Item> ItemIDs) {
		this.ItemIDs = ItemIDs;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer Quantity) {
		this.Quantity = Quantity;
	}
	public Integer getCost() {
		return Cost;
	}

	public void setCost(Integer cost) {
		this.Cost = cost;
	}
	public Item getItemIDs() {
		return itemIDs;
	}

	public void setItemIDs(Item itemIDs) {
		this.itemIDs = itemIDs;
	}
	public Long getIDitem() {
		return IDitem;
	}

	public void setIDitem(Long iDitem) {
		IDitem = iDitem;
	}
	
	@Override
	public String toString() {
		return "Order [ID =" + OrderID + ", CustomerID =" + CustomerID + "," +  ", ItemIDs =" + IDitem
				+ ", quantity =" + Quantity + "Cost =" + Cost +"]";
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
		if (Cost == null) {
			if (other.Cost != null)
				return false;
		} else if (!Cost.equals(other.Cost))
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

