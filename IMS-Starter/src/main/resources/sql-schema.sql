drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customerID` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `orderID` INT(11) NOT NULL AUTO_INCREMENT,
    `datePlaced` DATE NOT NULL DEFAULT GETDATE(),
    `customerID` INT(11),
    PRIMARY KEY (`orderID`),
    CONSTRAINT fk_id FOREIGN KEY (customerID) REFERENCES customers(customerID)
);

CREATE TABLE IF NOT EXISTS `ims`.`item` (
    `productID` INT(11) NOT NULL AUTO_INCREMENT,
    `productDescription` VARCHAR(40),
    `price` Double(6,2),
    PRIMARY KEY (`productID`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items` (
  orderItemID INT(11) NOT NULL AUTO_INCREMENT,
    `orderID` INT(11) ,
    `customerID` INT(11),
    `productID`INT(11),
	PRIMARY KEY (orderItemID),
CONSTRAINT fk_id FOREIGN KEY (customerID) REFERENCES customers(customerID), 
CONSTRAINT fk_orderID FOREIGN KEY (orderID) REFERENCES orders(orderID),
CONSTRAINT fk_productID FOREIGN KEY (productID) REFERENCES product(productID));




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

 


