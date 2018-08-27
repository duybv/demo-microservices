/***************************************************************************
 * Copyright 2017 by Homedirect - All rights reserved.                *    
 **************************************************************************/
package com.duybv.catalog.clients;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.duybv.catalog.model.ProductInventoryResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

/**
 *  Author : DuyBV
 * Aug 27, 2018
 */
@Service
@Slf4j
public class InventoryServiceClient {

  private final int defaultAvailableQuantity = 50;
  
  private final RestTemplate restTemplate;

  @Autowired
  public InventoryServiceClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @HystrixCommand(fallbackMethod = "getDefaultProductInventoryByCode",
      commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60")
  })
  //@HystrixCommand(commandKey = "inventory-by-productcode", fallbackMethod = "getDefaultProductInventoryByCode")
  public Optional<ProductInventoryResponse> getProductInventoryByCode(String productCode) {
    
    ResponseEntity<ProductInventoryResponse> itemResponseEntity =
        restTemplate.getForEntity("http://inventory-service/api/inventory/{code}",
            ProductInventoryResponse.class,
            productCode);

    if (isStatusOk(itemResponseEntity.getStatusCode())) {
      return Optional.ofNullable(itemResponseEntity.getBody());
    }

    log.error("Unable to get inventory level for product_code: " + productCode + ", StatusCode: " + itemResponseEntity.getStatusCode());
    return Optional.empty();
  }

  Optional<ProductInventoryResponse> getDefaultProductInventoryByCode(String productCode) {
    log.info("Returning default ProductInventoryByCode for productCode: " + productCode + " - availableQuantity: " + defaultAvailableQuantity);
    return Optional.of(new ProductInventoryResponse(productCode, defaultAvailableQuantity));
  }

  private boolean isStatusOk(HttpStatus httpStatus) {
    return HttpStatus.OK == httpStatus;
  }
}
