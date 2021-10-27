package com.qa.ims.controllers;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.qa.ims.controller.OrderController;

import com.qa.ims.persistence.dao.OrderDAO;



import com.qa.ims.utils.Utils;

import com.qa.ims.persistence.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		
		final long orderID=2;
		final String datePlaced="28/10/2021";
		final long customerID=1;
		final long itemID=3;
		final Order created = new Order(orderID,datePlaced,itemID,customerID);
		

		Mockito.when(utils.getLong()).thenReturn(orderID);
		Mockito.when(utils.getString()).thenReturn(datePlaced);
		Mockito.when(utils.getLong()).thenReturn(customerID);
		Mockito.when(utils.getLong()).thenReturn(itemID);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(2, "28/10/2021", 1,1));

		Mockito.when(dao.readAll()).thenReturn(orders);
		assertEquals(orders, controller.readAll());
		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(2, "28/10/2021", 1,1);

		Mockito.when(this.utils.getLong()).thenReturn(updated.getOrderID());
		Mockito.when(this.utils.getString()).thenReturn(updated.getDatePlaced());
		Mockito.when(this.utils.getLong()).thenReturn(updated.getId());
		Mockito.when(this.utils.getLong()).thenReturn(updated.getProductID());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}

	
	

	
	
