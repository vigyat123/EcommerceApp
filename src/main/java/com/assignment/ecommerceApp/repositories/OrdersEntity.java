package com.assignment.ecommerceApp.repositories;

import com.assignment.ecommerceApp.dto.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "buyer_email")
    private String buyerEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @OneToMany(targetEntity = ItemsOrderedEntity.class, cascade = CascadeType.ALL, mappedBy = "ordersEntity", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ItemsOrderedEntity> itemsOrderedEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public Set<ItemsOrderedEntity> getItemsOrderedEntities() {
        return itemsOrderedEntities;
    }

    public void setItemsOrderedEntities(Set<ItemsOrderedEntity> itemsOrderedEntities) {
        this.itemsOrderedEntities = itemsOrderedEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return Objects.equals(buyerEmail, that.buyerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerEmail);
    }
}
