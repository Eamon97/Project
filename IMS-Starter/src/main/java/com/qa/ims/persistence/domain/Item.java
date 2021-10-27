package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
private long productID;
private String productDescription;
private double price;



public Item(long productID2, String productDescription, double price) {
	super();
	this.productID = productID2;
	this.productDescription = productDescription;
	this.price= price;
}



public Item(String productDescription, double price) {
	this.productDescription = productDescription;
	this.price = price;
}



public long getProductID() {
	return productID;
}



public void setProductID(int productID) {
	this.productID = productID;
}



public String getProductDescription() {
	return productDescription;
}



public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public double getPrice() {
	return price;
}



public void setPrice(double price) {
	this.price = price;
}



@Override
public int hashCode() {
	return Objects.hash(price, productDescription, productID);
}



@Override
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (obj == null) {
		return false;
	}
	if (getClass() != obj.getClass()) {
		return false;
	}
	Item other = (Item) obj;
	return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
			&& Objects.equals(productDescription, other.productDescription) && productID == other.productID;
}



















	
}
