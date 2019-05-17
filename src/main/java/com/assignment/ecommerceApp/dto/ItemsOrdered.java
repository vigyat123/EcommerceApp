package com.assignment.ecommerceApp.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class ItemsOrdered {

    private Long id;

    @NotNull
    private Long itemId;

    @NotNull
    private Long numberOfItems;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal priceOfItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        ItemsOrdered that = (ItemsOrdered) o;
        return itemId.equals(that.itemId) &&
                numberOfItems.equals(that.numberOfItems) &&
                priceOfItem.equals(that.priceOfItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, numberOfItems, priceOfItem);
    }

    @Override
    public String toString() {
        return "ItemsOrdered{" +
                "itemId=" + itemId +
                ", numberOfItems=" + numberOfItems +
                ", priceOfItem=" + priceOfItem +
                '}';
    }
}
