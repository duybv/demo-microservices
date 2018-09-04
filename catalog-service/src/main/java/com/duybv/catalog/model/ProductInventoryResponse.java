/***************************************************************************
 * Copyright 2017 by Homedirect - All rights reserved.                *    
 **************************************************************************/
package com.duybv.catalog.model;

import lombok.Data;

/**
 *  Author : DuyBV
 * Aug 27, 2018
 */
@Data
public class ProductInventoryResponse {

  private String productCode;
  private int availableQuantity;

  private ProductInventoryResponse() {}

  private ProductInventoryResponse(String productCode, int availableQuantity) {
    this.productCode = productCode;
    this.availableQuantity = availableQuantity;
  }

  public static ProductInventoryResponse of(String productCode, int availableQuantity) {
    return new ProductInventoryResponse(productCode, availableQuantity);
  }
  
}
