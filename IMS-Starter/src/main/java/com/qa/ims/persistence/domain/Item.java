package com.qa.ims.persistence.domain;

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
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
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
	Item other = (Item) obj;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	if (productDescription == null) {
		if (other.productDescription != null)
			return false;
	} else if (!productDescription.equals(other.productDescription))
		return false;
	if (productID != other.productID)
		return false;
	return true;
}


@Override
public String toString() {
	return "Item [productID=" + productID + ", productDescription=" + productDescription + ", price=" + price + "]";
}



}
