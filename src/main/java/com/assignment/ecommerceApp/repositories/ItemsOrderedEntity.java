package com.assignment.ecommerceApp.repositories;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "items_ordered")
public class ItemsOrderedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrdersEntity ordersEntity;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "price_of_item")
    private BigDecimal priceOfItem;

    @Column(name = "number_of_items")
    private Long numberOfItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPriceOfItem() {
        return priceOfItem;
    }

    public void setPriceOfItem(BigDecimal priceOfItem) {
        this.priceOfItem = priceOfItem;
    }

    public Long getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsOrderedEntity that = (ItemsOrderedEntity) o;
        return ordersEntity.equals(that.ordersEntity) &&
                itemId.equals(that.itemId) &&
                priceOfItem.equals(that.priceOfItem) &&
                numberOfItems.equals(that.numberOfItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordersEntity, itemId, priceOfItem, numberOfItems);
    }
}
