package com.himalayancafe.config;

import com.himalayancafe.core.domain.Order;
import com.himalayancafe.core.repository.OrdersMemoryRepository;
import com.himalayancafe.core.repository.OrdersRepository;
import com.himalayancafe.core.services.OrderEventHandler;
import com.himalayancafe.core.services.OrderService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.UUID;

@Configuration
public class CoreConfig {


  @Bean
  public OrderService createService(OrdersRepository repo) {
    return new OrderEventHandler(repo);
  }

  @Bean
  public OrdersRepository createRepo() {
    return new OrdersMemoryRepository(new HashMap<UUID, Order>());
  }

}
