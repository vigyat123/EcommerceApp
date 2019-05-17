package com.assignment.ecommerceApp.repositories;

import com.assignment.ecommerceApp.dto.ItemType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    @Override
    Page<InventoryEntity> findAll(Pageable pageable);

    Page<InventoryEntity> findByItemType(final String itemType, final Pageable pageable);

    Optional<InventoryEntity> findByItemNameAndSeller(final String itemName, final String seller);

    @Override
    Optional<InventoryEntity> findById(Long aLong);
}
