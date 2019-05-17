package com.assignment.ecommerceApp.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class Inventory {

    private Long id;

    @NotBlank
    private String itemName;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal price;

    @NotNull
    private Long numberOfItems;

    @NotBlank
    private String seller;

    @NotNull
    private ItemType itemType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return itemName.equals(inventory.itemName) &&
                price.equals(inventory.price) &&
                numberOfItems.equals(inventory.numberOfItems) &&
                seller.equals(inventory.seller) &&
                itemType == inventory.itemType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, price, numberOfItems, seller, itemType);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", numberOfItems=" + numberOfItems +
                ", seller='" + seller + '\'' +
                ", itemType=" + itemType +
                '}';
    }
}
