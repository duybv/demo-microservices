package com.duybv.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  Author : duy.bui
 * Aug 26, 2018
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -2296748298741498972L;

  public ProductNotFoundException() {
  }

  public ProductNotFoundException(String message) {
    super(message);
  }

  public ProductNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public ProductNotFoundException(Throwable cause) {
    super(cause);
  }
  
}
