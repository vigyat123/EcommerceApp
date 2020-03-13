ALTER TABLE `inventory`
ADD COLUMN `tenant` VARCHAR(45) NOT NULL DEFAULT 'default' AFTER `item_type`;
