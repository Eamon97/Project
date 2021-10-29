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



public class OrderItemsDAO implements Dao<Order>{
	
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
public List<Order> readAll() {	try (Connection connection = DBUtils.getInstance().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM `ims`.`Order_Items`");) {
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

@Override
public Order read(Long id) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM `ims`.`Order_Items` WHERE orderItemID = ?");) {
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

public Order readLatest() {
	try (Connection connection = DBUtils.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `ims`.`Order_Items` ORDER BY orderItemID DESC LIMIT 1");) {
		resultSet.next();
		return modelFromResultSet(resultSet);
	} catch (Exception e) {
		LOGGER.debug(e);
		LOGGER.error(e.getMessage());
	}
	return null;
}

@Override
public Order create(Order t) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO `ims`.Order_Items(`orderID`,`customerID`,`productID`) VALUES (?,?,?)");) {
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





@Override
public Order update(Order t) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection
					.prepareStatement("UPDATE `ims`.`Order_Items` SET `customerID` = ?, `productID` = ? WHERE `orderID` = ?");) {
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

@Override
public int delete(long orderItemID) {
	try (Connection connection = DBUtils.getInstance().getConnection();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM `ims`.`Order_Items` WHERE `orderItemID` = ?");) {
		statement.setLong(1, orderItemID);
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
