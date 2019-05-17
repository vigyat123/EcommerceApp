CREATE TABLE `inventory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(256) NOT NULL,
  `price` decimal(19,6) NOT NULL,
  `number_of_items` bigint(20) NOT NULL,
  `seller` varchar(256) NOT NULL,
  `item_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci