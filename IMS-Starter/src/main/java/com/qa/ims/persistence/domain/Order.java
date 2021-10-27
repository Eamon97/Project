package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {
	private long orderID;
	private String datePlaced;
	private long customerID;
	private long productID;
	private Item item;
	private Customer customer;
	
	
	
	
	
	public Order(long orderID, String datePlaced, Item item, Customer customer) {
		super();
		this.orderID = orderID;
		this.datePlaced = datePlaced;
		this.item = item;
		this.customer = customer;
	}



	public Order(long orderID, String datePlaced, long customerID, long productID) {
		
		this.orderID = orderID;
		this.datePlaced = datePlaced;
		this.customerID = customerID;
		this.productID = productID;
	}
	


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


	public String getDatePlaced() {
		return datePlaced;
	}


	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
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
		return Objects.hash(customer, datePlaced, customerID, item, orderID, productID);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Order))
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(datePlaced, other.datePlaced)
				&& customerID == other.customerID && Objects.equals(item, other.item) && orderID == other.orderID
				&& productID == other.productID;
	}



	
	
	
	
	
	
	

}
