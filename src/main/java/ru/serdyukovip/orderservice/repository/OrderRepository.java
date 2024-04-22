package ru.serdyukovip.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serdyukovip.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
