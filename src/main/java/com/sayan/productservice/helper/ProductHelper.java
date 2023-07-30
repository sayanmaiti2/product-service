package com.sayan.productservice.helper;

import com.sayan.productservice.dto.ProductResponse;
import com.sayan.productservice.model.Product;

public class ProductHelper {

    public static ProductResponse mapProductToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
