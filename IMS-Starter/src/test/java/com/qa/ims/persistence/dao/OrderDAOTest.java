package com.qa.ims.persistence.dao;

import package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;

import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
private final OrderDAO DAO = new OrderDAO();

public Order(long orderID, String datePlaced, Item item, Customer customer)=new Order();

	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(orderID,"27/10/2021",item,customer);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(orderID,"27/10/2021",item,customer));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(orderID,"27/10/2021",item,customer), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long productID = 1;
		assertEquals(new Order(orderID,"27/10/2021",item,customer), DAO.read(productID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(orderID,"28/10/2021",item,customer);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}




