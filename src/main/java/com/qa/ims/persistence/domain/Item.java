package com.qa.ims.persistence.domain;

import java.math.BigDecimal;

public class Item {
	private Long id;
	private String IName;
	private BigDecimal price;

	public Item(String IName, BigDecimal price) {
		this.IName = IName;
		this.price = price;
	}

	public Item(Long id, String IName, BigDecimal price) {
		this.id = id;
		this.IName = IName;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIName() {
		return IName;
	}

	public void setIName(String IName) {
		this.IName = IName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String toString() {
		return "id:" + id + " Item name:" + IName + " price:" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IName == null) ? 0 : IName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Item other = (Item) obj;
		if (IName == null) {
			if (other.IName != null)
				return false;
		} else if (!IName.equals(other.IName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

}



