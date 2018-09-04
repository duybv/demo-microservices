package com.duybv.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duybv.catalog.entities.Product;
import com.duybv.catalog.exception.ProductNotFoundException;
import com.duybv.catalog.service.ProductService;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */
@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("")
  public List<Product> findAll() {
    return productService.findAll();
  }

  @GetMapping("/{code}")
  public Product findByCode(@PathVariable String code) {
    return productService.findByCode(code)
        .orElseThrow(() -> new ProductNotFoundException("Product with code ["+code+"] doesn't exist"));
  }

}
