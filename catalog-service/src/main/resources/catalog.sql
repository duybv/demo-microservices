CREATE database catalog;
use catalog;

CREATE TABLE `products` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(10),
  `name` varchar(50),
  `description` varchar(500),
  `price` double,
  `active` bit DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO products(id, code, name, description, price) VALUES
(1, 'P001', 'Product 1', 'Product 1 description', 25),
(2, 'P002', 'Product 2', 'Product 2 description', 32),
(3, 'P003', 'Product 3', 'Product 3 description', 50);
