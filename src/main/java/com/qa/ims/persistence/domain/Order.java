package com.qa.ims.persistence.domain;


public class Order {
	private Long id;
	private Long CustomerID;
	private Long OrderLineID;

	public Order(Long CustomerID, Long OrderLineID) {
		this.CustomerID = CustomerID;
		this.OrderLineID = OrderLineID;
	}

	public Order(Long id, Long CustomerID, Long OrderLineID) {
		this.id = id;
		this.CustomerID = CustomerID;
		this.OrderLineID = OrderLineID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String toString() {
		return "id:" + id + " CustomerID:" + CustomerID + " OrderLineID:" + OrderLineID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CustomerID == null) ? 0 : CustomerID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((OrderLineID == null) ? 0 : OrderLineID.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (OrderLineID == null) {
			if (other.OrderLineID != null)
				return false;
		} else if (!OrderLineID.equals(other.OrderLineID))
			return false;
		return true;
	}

}

