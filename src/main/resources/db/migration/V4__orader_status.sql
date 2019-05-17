ALTER TABLE `orders`
ADD COLUMN `order_status` VARCHAR(128) NOT NULL AFTER `buyer_email`;
