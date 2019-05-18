package com.assignment.ecommerceApp.services;

import com.assignment.ecommerceApp.dto.Inventory;
import com.assignment.ecommerceApp.dto.InventoryPage;
import com.assignment.ecommerceApp.dto.ItemType;
import com.assignment.ecommerceApp.exceptions.NotFoundException;
import com.assignment.ecommerceApp.mappers.InventoryMapper;
import com.assignment.ecommerceApp.repositories.InventoryEntity;
import com.assignment.ecommerceApp.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(final InventoryRepository inventoryRepository) {
        super();
        this.inventoryRepository = inventoryRepository;
    }

    public void addItem(Inventory inventory) {
        Optional<InventoryEntity> optionalInventoryEntity = inventoryRepository
                .findByItemNameAndSeller(inventory.getItemName(), inventory.getSeller());
        if (optionalInventoryEntity.isPresent()){
            // If item already present then increase the number of items and price of the item will get updated
            InventoryEntity inventoryEntitySaved = optionalInventoryEntity.get();
            Long numberOfItems = inventoryEntitySaved.getNumberOfItems();
            Long totalNumberOfItems = numberOfItems+inventory.getNumberOfItems();
            inventoryEntitySaved.setNumberOfItems(totalNumberOfItems);
            inventoryRepository.save(inventoryEntitySaved);
        }
        else {
            InventoryEntity inventoryEntity = InventoryMapper.map(inventory);
            inventoryRepository.save(inventoryEntity);
        }
    }

    public void editItem(Inventory inventory, Long id, InventoryEntity oldEntity) {
            InventoryEntity newEntity = InventoryMapper.mapOverOldEntity(inventory, oldEntity);

            inventoryRepository.save(newEntity);
    }

    public InventoryPage getAllItems(final Integer pageIndex,
                                     final Integer size) {
        final Pageable pageRequest = PageRequest.of(pageIndex, size, Sort.Direction.ASC, "id");
        final Page<InventoryEntity> inventories = inventoryRepository.findAll(pageRequest);
        return new InventoryPage(InventoryMapper.mapInventories(inventories.getContent()), inventories.getTotalPages(), inventories.getTotalElements());
    }

    public InventoryPage getAllItemsByItemType(Integer pageIndex, Integer size, String itemType) {
        final Pageable pageRequest = PageRequest.of(pageIndex, size, Sort.Direction.ASC, "id");
        final Page<InventoryEntity> inventories = inventoryRepository.findByItemType(itemType, pageRequest);
        return new InventoryPage(InventoryMapper.mapInventories(inventories.getContent()), inventories.getTotalPages(), inventories.getTotalElements());
    }

    public void deleteItemOfSeller(String itemName, String seller) throws Exception {
        Optional<InventoryEntity> optionalInventoryEntity = inventoryRepository.findByItemNameAndSeller(itemName, seller);
        if (optionalInventoryEntity.isPresent()){
            InventoryEntity inventoryEntity = optionalInventoryEntity.get();
            inventoryRepository.delete(inventoryEntity);
        }
        else {
            throw new NotFoundException("Item with this seller is not available");
        }
    }
}
