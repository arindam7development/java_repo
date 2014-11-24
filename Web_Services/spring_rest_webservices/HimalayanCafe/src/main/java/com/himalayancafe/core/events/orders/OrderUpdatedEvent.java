package com.himalayancafe.core.events.orders;

import com.himalayancafe.core.events.UpdatedEvent;

import java.util.UUID;

public class OrderUpdatedEvent extends UpdatedEvent {

  private UUID key;
  private OrderDetails orderDetails;

  public OrderUpdatedEvent(UUID key, OrderDetails orderDetails) {
    this.key = key;
    this.orderDetails = orderDetails;
  }

  public UUID getKey() {
    return key;
  }

  public OrderDetails getOrderDetails() {
    return orderDetails;
  }
}
