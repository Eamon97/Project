package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item>{

	public static final Logger LOGGER = LogManager.getLogger();
	
@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		long productID = resultSet.getLong("productID");
		String productDescription = resultSet.getString("productDescription");
		double price= resultSet.getDouble("price");
		
		return new Item(productID,productDescription,price);
	}
	
	@Override
	public List<Item> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `ims`.`Item`");) {
			List<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(modelFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Item readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `ims`.`Item` ORDER BY productID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Item read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item create(Item t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO `ims`.`Item`(productDescription,price) VALUES (?,?)");) {
			
			statement.setString(1, t.getProductDescription());
			statement.setDouble(2, t.getPrice());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		

	@Override
	public Item update(Item t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE `ims`.`Item` SET price = ?, productDescription = ? WHERE productID = ?");) {
			statement.setDouble(1, t.getPrice());
			statement.setString(2, t.getProductDescription());
			statement.setLong(3, t.getProductID());
			statement.executeUpdate();
			return read(t.getProductID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		

	@Override
	public int delete(long productID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM `ims`.`Item` WHERE productID = ?");) {
			statement.setLong(1, productID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public Order addItem(Order order) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
