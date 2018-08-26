package com.duybv.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duybv.catalog.entity.Product;
import com.duybv.catalog.repo.ProductRepository;

import lombok.extern.slf4j.Slf4j;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */
@Service
@Transactional
@Slf4j
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> findProductByCode(String code) {
    return productRepository.findByCode(code);
  }

}
