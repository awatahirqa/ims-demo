package com.qa.ims.persistence.domain;


public class Order {
	private Long ID;
	private Long CustomerID;
	private Long OrderLineID;
	private Long ItemID;
	private Long Quantity;

	public Order(Long CustomerID, Long OrderLineID,Long ItemID,Long Quantity) {
		this.CustomerID = CustomerID;
		this.OrderLineID = OrderLineID;
		this.ItemID = ItemID;
		this.Quantity = Quantity;
	}

	public Order(Long ID, Long CustomerID, Long OrderLineID,Long ItemID,Long Quantity) {
		this.ID = ID;
		this.CustomerID = CustomerID;
		this.OrderLineID = OrderLineID;
		this.ItemID = ItemID;
		this.Quantity = Quantity;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long CustomerID) {
		this.CustomerID = CustomerID;
	}

	public Long getOrderLineID() {
		return OrderLineID;
	}

	public void setOrderLineID(Long OrderLineID) {
		this.OrderLineID = OrderLineID;
	}
	

	public Long getItemID() {
		return ItemID;
	}

	public void setItemID(Long ItemID) {
		this.ItemID = ItemID;
	}

	public Long getQuantity() {
		return Quantity;
	}

	public void setQuantity(Long Quantity) {
		this.Quantity = Quantity;
	}

	
	@Override
	public String toString() {
		return "Order [ID =" + ID + ", CustomerID =" + CustomerID + ", OrderLineID =" + OrderLineID + ", ItemID =" + ItemID
				+ ", quantity =" + Quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CustomerID == null) ? 0 : CustomerID.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((OrderLineID == null) ? 0 : OrderLineID.hashCode());
		result = prime * result + ((ItemID == null) ? 0 : ItemID.hashCode());
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
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (OrderLineID == null) {
			if (other.OrderLineID != null)
				return false;
		} else if (!OrderLineID.equals(other.OrderLineID))
			return false;
		if (ItemID == null) {
			if (other.ItemID != null)
				return false;
		} else if (!ItemID.equals(other.ItemID))
			return false;
		if (Quantity == null) {
			if (other.Quantity != null)
				return false;
		} else if (!Quantity.equals(other.Quantity))
			return false;
		return true;
	}

}

