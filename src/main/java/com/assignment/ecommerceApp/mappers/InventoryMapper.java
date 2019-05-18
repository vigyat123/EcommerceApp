package com.assignment.ecommerceApp.mappers;

import com.assignment.ecommerceApp.dto.Inventory;
import com.assignment.ecommerceApp.repositories.InventoryEntity;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryMapper {

    public static InventoryEntity map(Inventory inventory){
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setItemName(inventory.getItemName());
        inventoryEntity.setPrice(inventory.getPrice());
        inventoryEntity.setItemType(inventory.getItemType());
        inventoryEntity.setNumberOfItems(inventory.getNumberOfItems());
        inventoryEntity.setSeller(inventory.getSeller());
        return inventoryEntity;
    }

    public static InventoryEntity mapOverOldEntity(Inventory inventory, InventoryEntity oldEntity){
        oldEntity.setItemName(inventory.getItemName());
        oldEntity.setPrice(inventory.getPrice());
        oldEntity.setItemType(inventory.getItemType());
        oldEntity.setNumberOfItems(inventory.getNumberOfItems());
        oldEntity.setSeller(inventory.getSeller());
        return oldEntity;
    }

    public static Inventory map(InventoryEntity inventoryEntity){
        Inventory inventory = new Inventory();
        inventory.setId(inventoryEntity.getId());
        inventory.setItemName(inventoryEntity.getItemName());
        inventory.setPrice(inventoryEntity.getPrice());
        inventory.setItemType(inventoryEntity.getItemType());
        inventory.setNumberOfItems(inventoryEntity.getNumberOfItems());
        inventory.setSeller(inventoryEntity.getSeller());
        return inventory;
    }

    public static List<Inventory> mapInventories(final List<InventoryEntity> inventoryEntities){
        return inventoryEntities.stream().map(InventoryMapper::map).collect(Collectors.toList());
    }
}
