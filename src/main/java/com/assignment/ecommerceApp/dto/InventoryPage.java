package com.assignment.ecommerceApp.dto;

import java.util.List;
import java.util.Objects;

public class InventoryPage {
    private List<Inventory> elements;
    private Integer totalPages;
    private Long totalElements;

    public InventoryPage(List<Inventory> elements, Integer totalPages, Long totalElements) {
        this.elements = elements;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public List<Inventory> getElements() {
        return elements;
    }

    public void setElements(List<Inventory> elements) {
        this.elements = elements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryPage that = (InventoryPage) o;
        return Objects.equals(elements, that.elements) &&
                Objects.equals(totalPages, that.totalPages) &&
                Objects.equals(totalElements, that.totalElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, totalPages, totalElements);
    }

    @Override
    public String toString() {
        return "InventoryPage{" +
                "elements=" + elements +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                '}';
    }
}
