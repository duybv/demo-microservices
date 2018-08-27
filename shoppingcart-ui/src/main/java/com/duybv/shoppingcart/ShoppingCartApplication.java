package com.duybv.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ShoppingCartApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShoppingCartApplication.class, args);
  }

}
