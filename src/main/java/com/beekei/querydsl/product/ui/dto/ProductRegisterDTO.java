package com.beekei.querydsl.product.ui.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ProductRegisterDTO {
    private String name;
    private int price;
}
