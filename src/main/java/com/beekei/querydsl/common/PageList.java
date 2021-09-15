package com.beekei.querydsl.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageList<T> {
    private List<T> contents;
    private long totalElements;
    private int totalPages;
    private int number;
    public int getNumber() {
        return this.number + 1;
    }
}
