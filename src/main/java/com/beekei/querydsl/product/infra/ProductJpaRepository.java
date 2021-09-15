package com.beekei.querydsl.product.infra;

import com.beekei.querydsl.product.domain.Product;
import com.beekei.querydsl.product.domain.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long>, ProductRepository {
}
