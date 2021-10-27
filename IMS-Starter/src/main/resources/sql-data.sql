INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Eamon', 'Moradi');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Mark', 'Rob');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('', '');

INSERT INTO `ims`.`item` (`productDescription`, `price`) VALUES ('ball', '4.99');
INSERT INTO `ims`.`item` (`productDescription`, `price`) VALUES ('trainers', '20.00');
INSERT INTO `ims`.`item` (`productDescription`, `price`) VALUES ('bat', '7.00');

INSERT INTO `ims`.`orders` (`customerID`) VALUES ('2');
INSERT INTO `ims`.`orders` (`customerID`) VALUES ('1');
INSERT INTO `ims`.`orders` (`customerID`) VALUES ('3');

INSERT INTO `ims`.`order_items` (`orderID`,`customerID`,`productID`) VALUES ('1','2','2');
INSERT INTO `ims`.`order_items` (`orderID`,`customerID`,`productID`) VALUES ('1','2','1');
INSERT INTO `ims`.`order_items` (`orderID`,`customerID`,`productID`) VALUES ('3','3','1');
INSERT INTO `ims`.`order_items` (`orderID`,`customerID`,`productID`) VALUES ('2','1','2');
INSERT INTO `ims`.`order_items` (`orderID`,`customerID`,`productID`) VALUES ('2','1','3');
INSERT INTO `ims`.`order_items` (`orderID`,`customerID`,`productID`) VALUES ('3','3','1');




