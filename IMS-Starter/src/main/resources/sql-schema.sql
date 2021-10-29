drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims`;

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



/*Creating order items table with a composite primary key*/

   /* CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
    `orderID` INT(11) ,
    `id` INT(11),
    `productID`INT(11),
CONSTRAINT PK_orders PRIMARY KEY (orderID, customerID,productID),
CONSTRAINT fk_id FOREIGN KEY (customerID) REFERENCES customers(customerID), 
CONSTRAINT fk_orderID FOREIGN KEY (orderID) REFERENCES orders(orderID),
CONSTRAINT fk_productID FOREIGN KEY (productID) REFERENCES product(productID)
);


CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
  orderItemID INT(11) NOT NULL AUTO_INCREMENT,
    `orderID` INT(11) ,
    `productID`INT(11),
	PRIMARY KEY (orderItemID),
CONSTRAINT fk_orderID FOREIGN KEY (orderID) REFERENCES orders(orderID),
CONSTRAINT fk_productID FOREIGN KEY (productID) REFERENCES product(productID));


 */

 


