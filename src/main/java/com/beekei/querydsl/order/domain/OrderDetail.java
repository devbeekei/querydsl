package com.beekei.querydsl.order.domain;

import com.beekei.querydsl.product.domain.Product;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Embeddable
public class OrderDetail {

    @ColumnDefault("1")
    @Column(nullable = false)
    private int count;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
