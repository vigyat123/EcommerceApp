package com.assignment.ecommerceApp.mappers;

import com.assignment.ecommerceApp.dto.ItemsOrdered;
import com.assignment.ecommerceApp.dto.Order;
import com.assignment.ecommerceApp.dto.OrderStatus;
import com.assignment.ecommerceApp.repositories.OrdersEntity;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrdersEntity map(Order order){
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setDate(LocalDate.now());
        ordersEntity.setBuyerEmail(order.getBuyerEmail());
        ordersEntity.setOrderStatus(order.getOrderStatus());
        ordersEntity.setItemsOrderedEntities(order.getItemsOrderedSet().stream().map(x -> ItemsOrderedMapper
                .map(x, ordersEntity)).collect(Collectors.toCollection(LinkedHashSet::new)));
        return ordersEntity;
    }

    public static Order map(OrdersEntity ordersEntity){
        Order order = new Order();
        order.setId(ordersEntity.getId());
        order.setDate(String.valueOf(ordersEntity.getDate()));
        order.setBuyerEmail(ordersEntity.getBuyerEmail());
        order.setOrderStatus(ordersEntity.getOrderStatus());
        order.setItemsOrderedSet(ordersEntity.getItemsOrderedEntities().stream().map(ItemsOrderedMapper::map).collect(Collectors.toCollection(LinkedHashSet::new)));
        return order;
    }

    public static List<Order> mapOrders(final List<OrdersEntity> ordersEntities){
        return ordersEntities.stream().map(OrderMapper::map).collect(Collectors.toList());
    }
}
