package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO itemDAO;
	private Utils utils;
	
	
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter a product ID");
		long productID = utils.getLong();
		LOGGER.info("Please enter product description");
		String productDescription = utils.getString();
		LOGGER.info("Please enter the price");
		double price=utils.getDouble();
		Item item = itemDAO.create(new Item(productID, productDescription,price));
		LOGGER.info("Item created");
		return item;
	}
		

	@Override
	public Item update() {
		LOGGER.info("Please enter a product ID");
		long productID = utils.getLong();
		LOGGER.info("Please enter product description");
		String productDescription = utils.getString();
		LOGGER.info("Please enter the price");
		double price=utils.getDouble();
		Item item = itemDAO.update(new Item(productID, productDescription,price));
		LOGGER.info("Item Updated");
		return item;
	}
	

	@Override
	public int delete() {
		LOGGER.info("Please enter the product id of the item you would like to delete");
		Long productID = utils.getLong();
		return itemDAO.delete(productID);
	}
		

}
