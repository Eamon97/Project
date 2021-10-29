package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderDAO orderDAO;
	private Utils utils;
	
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a order ID");
		long orderID = utils.getLong();
		LOGGER.info("Please enter the customer ID");
		long customerID=utils.getLong();
		LOGGER.info("Please enter the product ID");
		long productID=utils.getLong();
		Order order = orderDAO.create(new Order(orderID,customerID,productID));
		LOGGER.info("order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter a order ID");
		long orderID = utils.getLong();
		LOGGER.info("Please enter the customer ID");
		long customerID=utils.getLong();
		LOGGER.info("Please enter the product ID");
		long productID=utils.getLong();
		Order order = orderDAO.update(new Order(orderID,customerID,productID));
		LOGGER.info("order updated");
		return order;
		
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the order ID of the order you would like to cancel");
		Long orderID = utils.getLong();
		return orderDAO.delete(orderID);
	}

}
