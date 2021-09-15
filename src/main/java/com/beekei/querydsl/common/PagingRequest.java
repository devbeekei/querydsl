package com.beekei.querydsl.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PagingRequest {

    private int size;
    private int page;

    public void setPage(int page) {
        this.page = page <= 0 ? 1 : page;
    }

    public void setSize(int size) {
        int DEFAULT_SIZE = 10;
        int MAX_SIZE = 50;
        this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
    }

    public PageRequest pageable() {
        return PageRequest.of(page - 1, size);
    }

}