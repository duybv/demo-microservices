package com.duybv.catalog.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duybv.catalog.entity.Product;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByCode(String code);

}
