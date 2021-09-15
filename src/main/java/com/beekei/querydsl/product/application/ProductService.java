package com.beekei.querydsl.product.application;

import com.beekei.querydsl.common.PageList;
import com.beekei.querydsl.common.PagingRequest;
import com.beekei.querydsl.product.application.dto.ProductDTO;
import com.beekei.querydsl.product.domain.Product;
import com.beekei.querydsl.product.domain.ProductRepository;
import com.beekei.querydsl.product.domain.ProductRepositorySupport;
import com.beekei.querydsl.product.ui.dto.ProductRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRepositorySupport productRepositorySupport;

    @Transactional
    public void productRegister(ProductRegisterDTO productRegisterDTO) {
        Product product = Product.builder()
                .name(productRegisterDTO.getName())
                .price(productRegisterDTO.getPrice())
                .build();
        productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public PageList<ProductDTO> productList(PagingRequest pagingRequest) {
        Page<ProductDTO> productDTOPage = productRepositorySupport.pageList(pagingRequest);
        return new PageList<>(
                productDTOPage.getContent(),
                productDTOPage.getTotalElements(),
                productDTOPage.getTotalPages(),
                productDTOPage.getNumber()
        );
    }

}
