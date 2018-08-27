package com.duybv.inventory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duybv.inventory.entities.InventoryItem;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

  Optional<InventoryItem> findByProductCode(String productCode);

}
