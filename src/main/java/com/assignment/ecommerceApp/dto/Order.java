package com.assignment.ecommerceApp.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class Order {

    private Long id;

    private String  date;

    private BigDecimal totalPrice;

    @NotBlank
    @Email
    private String buyerEmail;

    private OrderStatus orderStatus;

    @NotNull
    @Valid
    private Set<ItemsOrdered> itemsOrderedSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<ItemsOrdered> getItemsOrderedSet() {
        return itemsOrderedSet;
    }

    public void setItemsOrderedSet(Set<ItemsOrdered> itemsOrderedSet) {
        this.itemsOrderedSet = itemsOrderedSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return buyerEmail.equals(order.buyerEmail) &&
                itemsOrderedSet.equals(order.itemsOrderedSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerEmail, itemsOrderedSet);
    }
}
