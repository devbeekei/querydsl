package com.beekei.querydsl.order.infra;

import com.beekei.querydsl.order.domain.Order;
import com.beekei.querydsl.order.domain.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long>, OrderRepository {
}
