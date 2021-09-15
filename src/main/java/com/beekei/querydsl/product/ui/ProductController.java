package com.beekei.querydsl.product.ui;

import com.beekei.querydsl.common.ApiResponse;
import com.beekei.querydsl.common.PageList;
import com.beekei.querydsl.common.PagingRequest;
import com.beekei.querydsl.product.application.ProductService;
import com.beekei.querydsl.product.application.dto.ProductDTO;
import com.beekei.querydsl.product.ui.dto.ProductRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping(name = "상품 등록", value = "")
    public ApiResponse register(final @RequestBody ProductRegisterDTO productRegisterDTO) {
        productService.productRegister(productRegisterDTO);
        return new ApiResponse(200, "Success", null);
    }

    @GetMapping(name = "상품 목록", value = "")
    public ApiResponse<PageList<ProductDTO>> list(@RequestParam String searchName, @RequestParam int size, @RequestParam int page) {
        PageList<ProductDTO> productList = productService.productList(searchName, new PagingRequest(size, page));
        return new ApiResponse<>(200, "Success", productList);
    }

}
