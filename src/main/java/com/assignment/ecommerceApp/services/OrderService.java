package com.assignment.ecommerceApp.services;

import com.assignment.ecommerceApp.dto.*;
import com.assignment.ecommerceApp.exceptions.NotFoundException;
import com.assignment.ecommerceApp.exceptions.OutOfStockException;
import com.assignment.ecommerceApp.mappers.OrderMapper;
import com.assignment.ecommerceApp.repositories.InventoryEntity;
import com.assignment.ecommerceApp.repositories.InventoryRepository;
import com.assignment.ecommerceApp.repositories.OrderRepository;
import com.assignment.ecommerceApp.repositories.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public OrderService(final OrderRepository orderRepository,
                        final InventoryRepository inventoryRepository) {
        super();
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public void createOrder(Order order) throws Exception {
        Boolean createOrderApproved = false;
        for (ItemsOrdered itemsOrdered:order.getItemsOrderedSet()){
            Optional<InventoryEntity> optionalInventory = inventoryRepository.findById(itemsOrdered.getItemId());
            if (optionalInventory.isPresent()){
                InventoryEntity inventoryEntity = optionalInventory.get();
                if (inventoryEntity.getNumberOfItems() <(itemsOrdered.getNumberOfItems())){
                    createOrderApproved = false;
                    throw new OutOfStockException("Item with the given seller is Currently Unavailable. Same Item might be available with different seller");
                }
                else {
                    Long totalNumOfItems = inventoryEntity.getNumberOfItems()-itemsOrdered.getNumberOfItems();
                    inventoryEntity.setNumberOfItems(totalNumOfItems);
                    inventoryRepository.save(inventoryEntity);
                    createOrderApproved = true;
                }
            }
            else {
                createOrderApproved = false;
                throw new OutOfStockException("Item with the given seller is Currently Unavailable. Same Item might be available with different seller");
            }
        }
        if (createOrderApproved) {
            order.setOrderStatus(OrderStatus.ADDED_TO_CART);
            OrdersEntity ordersEntity = OrderMapper.map(order);
            BigDecimal totalPrice = BigDecimal.ZERO;
            for (ItemsOrdered itemsOrderedSet : order.getItemsOrderedSet()) {
                BigDecimal totalNumberOfItems = new BigDecimal(itemsOrderedSet.getNumberOfItems());
                BigDecimal totalPriceOfItem = itemsOrderedSet.getPriceOfItem().multiply(totalNumberOfItems);
                totalPrice = totalPrice.add(totalPriceOfItem);
            }
            ordersEntity.setTotalPrice(totalPrice);
            orderRepository.save(ordersEntity);
        }
    }

    public void changeOrderStatus(final Long orderId, Boolean placeOrder) throws Exception {
        Optional<OrdersEntity> ordersEntityOptional = orderRepository.findById(orderId);
        if (ordersEntityOptional.isPresent()){
            OrdersEntity ordersEntity = ordersEntityOptional.get();
            if (placeOrder) {
                ordersEntity.setOrderStatus(OrderStatus.ORDER_PLACED);
            }
            else {
                ordersEntity.setOrderStatus(OrderStatus.ORDER_CANCELLED);
            }
            orderRepository.save(ordersEntity);
        }
        else {
            throw new NotFoundException("Order Not Present");
        }
    }

    public OrdersPage getAllOrders(final Integer pageIndex,
                                  final Integer size) {
        final Pageable pageRequest = PageRequest.of(pageIndex, size, Sort.Direction.ASC, "id");
        final Page<OrdersEntity> inventories = orderRepository.findAll(pageRequest);
        return new OrdersPage(OrderMapper.mapOrders(inventories.getContent()), inventories.getTotalPages(), inventories.getTotalElements());
    }
}
