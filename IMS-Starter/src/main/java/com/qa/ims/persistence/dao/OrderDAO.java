package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;


public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		
		Long orderID = resultSet.getLong("orderID");
		Date datePlaced = resultSet.getDate(2);
		long customerID = resultSet.getLong("customerID");
		long productID = resultSet.getLong("productID");
		return new Order(orderID,datePlaced,customerID,productID);
	}
	
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `ims`.`Orders`");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `ims`.`Orders` ORDER BY orderID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM `ims`.`Orders` WHERE orderID = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		
/* This method will create an Order*/
	@Override
	public Order create(Order t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO `ims`.Orders(`orderID`,`customerID`,`productID`) VALUES (?,?,?)");) {
			statement.setLong(1, t.getOrderID());
			statement.setLong(2, t.getId());
			statement.setLong(3, t.getProductID());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		
	/* This method will update an Order*/
	@Override
	public Order update(Order t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE `ims`.`Orders` SET `customerID` = ?, `productID` = ? WHERE `orderID` = ?");) {
			statement.setLong(1, t.getId());
			statement.setLong(2, t.getProductID());
			statement.setLong(3, t.getOrderID());
			statement.executeUpdate();
			return read(t.getOrderID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/* This method adds an item to Order*/
	@Override
	public Order addItem(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO ims.Orders(`productID`) VALUES (?)");) {
			
			statement.setLong(1, order.getProductID());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
		
	/* This method will delete an Order*/
	@Override
	public int delete(long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM `ims`.`Orders` WHERE `orderID` = ?");) {
			statement.setLong(1, orderID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
		
public Order costOfOrder(long orderID) {
	
	try (Connection connection = DBUtils.getInstance().getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT Item.price FROM `ims`.`Orders` WHERE `orderID` = ?");) {
	statement.setDouble(1, orderID);
	try (ResultSet resultSet = statement.executeQuery();) {
		resultSet.next();
		return modelFromResultSet(resultSet);
	}
} catch (Exception e) {
	LOGGER.debug(e);
	LOGGER.error(e.getMessage());
}
return null;
}

}
