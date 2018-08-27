/***************************************************************************
 * Copyright 2017 by Homedirect - All rights reserved.                *    
 **************************************************************************/
package com.duybv.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *  Author : DuyBV
 * Aug 27, 2018
 */
@Data
@AllArgsConstructor
public class ProductInventoryResponse {
    private String productCode;
    private int availableQuantity;
}
