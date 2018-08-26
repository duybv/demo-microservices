package com.duybv.catalog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HomeController {

  @Value("${name}")
  private String name;

  @GetMapping(value = "/name") 
  public String getName() {
    return name;
  }

}
