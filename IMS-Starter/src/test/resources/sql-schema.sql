drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;



USE `ims`;

DROP TABLE IF EXISTS `Customers`;
DROP TABLE IF EXISTS `Item`;
DROP TABLE IF EXISTS `Order_Items`;

CREATE TABLE IF NOT EXISTS `ims`.`Customers` (
    `customerID` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`customerID`)
);

CREATE TABLE IF NOT EXISTS `ims`.`Item` (
    `productID` INT(11) NOT NULL AUTO_INCREMENT,
    `productDescription` VARCHAR(40),
    `price` Double,
    PRIMARY KEY (`productID`)
);                                                       
DROP TABLE IF EXISTS `Orders`;

	CREATE TABLE IF NOT EXISTS `ims`.`Orders` (
    `orderID` INT(11) NOT NULL AUTO_INCREMENT,
    `datePlaced` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `customerID` INT(11),
    `productID` INT(11),
    PRIMARY KEY (orderID),
    FOREIGN KEY (customerID) REFERENCES `Customers`(customerID),
FOREIGN KEY (productID) REFERENCES `Item`(productID)
);
CREATE TABLE IF NOT EXISTS `ims`.`Order_Items` (
  orderItemID INT(11) NOT NULL AUTO_INCREMENT,
    `orderID` INT ,
    `customerID` INT,
    `productID`INT,
	PRIMARY KEY (`orderItemID`),
FOREIGN KEY (customerID) REFERENCES Customers(customerID), 
FOREIGN KEY (orderID) REFERENCES Orders(orderID),
FOREIGN KEY (productID) REFERENCES Item(productID));
