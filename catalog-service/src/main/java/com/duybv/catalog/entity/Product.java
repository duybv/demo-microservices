package com.duybv.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */
@Data
@Entity
@Table(name = "products")
public class Product {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(nullable = false, unique = true)
  private String code;
  @Column(nullable = false)
  private String name;
  private String description;
  private double price;

}
