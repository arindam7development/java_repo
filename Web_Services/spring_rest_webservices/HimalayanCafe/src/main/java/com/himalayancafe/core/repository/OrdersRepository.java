package com.himalayancafe.core.repository;

import com.himalayancafe.core.domain.Order;
import com.himalayancafe.core.events.CreateEvent;
import com.himalayancafe.core.events.DeleteEvent;
import com.himalayancafe.core.events.RequestReadEvent;
import com.himalayancafe.core.events.UpdatedEvent;
import com.himalayancafe.core.events.orders.*;

import java.util.List;
import java.util.UUID;

//TODO, make this event based again, with persistence integration events.
public interface OrdersRepository {

  Order save(Order order);

  void delete(UUID key);

  Order findById(UUID key);

  List<Order> findAll();
}
