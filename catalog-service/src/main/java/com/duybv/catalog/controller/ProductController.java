package com.duybv.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duybv.catalog.entity.Product;
import com.duybv.catalog.exception.ProductNotFoundException;
import com.duybv.catalog.service.ProductService;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("")
  public List<Product> allProducts() {
    return productService.findAllProducts();
  }

  @GetMapping("/{code}")
  public Product productByCode(@PathVariable String code) {
    return productService.findProductByCode(code)
        .orElseThrow(() -> new ProductNotFoundException("Product with code ["+code+"] doesn't exist"));
  }
  
}
