package com.assignment.ecommerceApp.mappers;

import com.assignment.ecommerceApp.dto.ItemsOrdered;
import com.assignment.ecommerceApp.repositories.ItemsOrderedEntity;
import com.assignment.ecommerceApp.repositories.OrdersEntity;

public class ItemsOrderedMapper {

    public static ItemsOrderedEntity map(ItemsOrdered itemsOrdered, OrdersEntity ordersEntity){
        ItemsOrderedEntity itemsOrderedEntity = new ItemsOrderedEntity();
        itemsOrderedEntity.setItemId(itemsOrdered.getItemId());
        itemsOrderedEntity.setNumberOfItems(itemsOrdered.getNumberOfItems());
        itemsOrderedEntity.setPriceOfItem(itemsOrdered.getPriceOfItem());
        itemsOrderedEntity.setOrdersEntity(ordersEntity);
        return itemsOrderedEntity;
    }

    public static ItemsOrdered map(ItemsOrderedEntity itemsOrderedEntity){
        ItemsOrdered itemsOrdered = new ItemsOrdered();
        itemsOrdered.setId(itemsOrderedEntity.getId());
        itemsOrdered.setItemId(itemsOrderedEntity.getItemId());
        itemsOrdered.setNumberOfItems(itemsOrderedEntity.getNumberOfItems());
        itemsOrdered.setPriceOfItem(itemsOrderedEntity.getPriceOfItem());
        return itemsOrdered;
    }
}
