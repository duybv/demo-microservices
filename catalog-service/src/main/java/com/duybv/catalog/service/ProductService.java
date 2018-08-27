package com.duybv.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duybv.catalog.clients.InventoryServiceClient;
import com.duybv.catalog.entities.Product;
import com.duybv.catalog.model.ProductInventoryResponse;
import com.duybv.catalog.repositories.ProductRepository;

import lombok.extern.slf4j.Slf4j;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */
@Service
@Transactional
@Slf4j
public class ProductService {

  @Autowired
  private ProductRepository productRepository;
  
  @Autowired
  private InventoryServiceClient inventoryServiceClient;

  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> findProductByCode(String code) {
    Optional<Product> productOptional = productRepository.findByCode(code);
    
    if(!productOptional.isPresent()) {
      log.info("Not found product has code: " + code);
      return Optional.empty();
    }

    log.info("Fetching inventory level for product_code: " + code);

    Optional<ProductInventoryResponse> productInventoryOptional = inventoryServiceClient.getProductInventoryByCode(code);

    Integer quantity = productInventoryOptional.get().getAvailableQuantity();
    log.info("Available quantity: " + quantity);
    
    productOptional.get().setInStock(quantity > 0);

    return productOptional;
  }

}
