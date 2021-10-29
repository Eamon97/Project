package com.qa.ims.persistence.domain;

import java.sql.Date;

public class Order {
	private long orderID;
	private Date datePlaced;
	private long customerID;
	private long productID;
	private Item item;
	private Customer customer;
	

	public Order(long orderID, Date datePlaced, long customerID, long productID) {
		super();
		this.orderID = orderID;
		this.datePlaced = datePlaced;
		this.customerID = customerID;
		this.productID = productID;
	}
	
	public Order(long orderID, long customerID, long productID) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.productID = productID;    }

	public Order(long orderID, Date datePlaced, Item item, Customer customer) {
		super();
		this.orderID = orderID;
		this.datePlaced = datePlaced;
		this.item = item;
		this.customer = customer;    			}



	public Order(long id, long productID) {
		this.customerID = id;
		this.productID = productID;
	}



	public long getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	


	public long getId() {
		return customerID;
	}


	public void setId(long id) {
		this.customerID = id;
	}


	public long getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}

	
	

	public Item getItem() {
		return item;
	}



	public void setItem(Item item) {
		this.item = item;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}



	public void setProductID(long productID) {
		this.productID = productID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (int) (customerID ^ (customerID >>> 32));
		result = prime * result + ((datePlaced == null) ? 0 : datePlaced.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + (int) (orderID ^ (orderID >>> 32));
		result = prime * result + (int) (productID ^ (productID >>> 32));
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
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (customerID != other.customerID)
			return false;
		if (datePlaced == null) {
			if (other.datePlaced != null)
				return false;
		} else if (!datePlaced.equals(other.datePlaced))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (orderID != other.orderID)
			return false;
		if (productID != other.productID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", datePlaced=" + datePlaced + ", customerID=" + customerID
				+ ", productID=" + productID + ", item=" + item + ", customer=" + customer + "]";
	}



	
	

}
