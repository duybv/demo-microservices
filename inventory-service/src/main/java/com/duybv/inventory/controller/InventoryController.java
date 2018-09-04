package com.duybv.inventory.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duybv.inventory.entities.InventoryItem;
import com.duybv.inventory.repositories.InventoryItemRepository;

import lombok.extern.slf4j.Slf4j;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */
@RestController
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryController {

  private final InventoryItemRepository inventoryItemRepository;

  @Autowired
  public InventoryController(InventoryItemRepository inventoryItemRepository) {
    this.inventoryItemRepository = inventoryItemRepository;
  }

  @GetMapping("/{productCode}")
  public ResponseEntity<InventoryItem> findInventoryByProductCode(@PathVariable("productCode") String productCode) {
    log.info("Finding inventory for product code :" + productCode);
    Optional<InventoryItem> inventoryItem = inventoryItemRepository.findByProductCode(productCode);
    if(inventoryItem.isPresent()) {
      return new ResponseEntity<>(inventoryItem.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
