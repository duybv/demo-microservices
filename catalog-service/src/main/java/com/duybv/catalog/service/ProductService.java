package com.duybv.catalog.service;

import java.util.List;
import java.util.Optional;

import com.duybv.catalog.entities.Product;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */

public interface ProductService {

  List<Product> findAll();

  Optional<Product> findByCode(String code);
  
}
