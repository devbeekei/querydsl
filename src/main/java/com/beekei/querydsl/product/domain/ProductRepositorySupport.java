package com.beekei.querydsl.product.domain;

import com.beekei.querydsl.common.PagingRequest;
import com.beekei.querydsl.product.application.dto.ProductDTO;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.beekei.querydsl.product.domain.QProduct.product;

@Repository
public class ProductRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public ProductRepositorySupport(JPAQueryFactory queryFactory) {
        super(Product.class);
        this.queryFactory = queryFactory;
    }

    public Page<ProductDTO> pageList(PagingRequest pagingRequest) {
        Pageable paging = pagingRequest.pageable();

        QueryResults<ProductDTO> result = queryFactory
                .select(Projections.constructor(ProductDTO.class,
                        product.id, product.name, product.price
                )).from(product)

                .orderBy(product.id.desc())
                .offset(paging.getOffset())
                .limit(paging.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(), paging, result.getTotal());
    }

}
