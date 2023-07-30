package com.sayan.productservice.service;

import com.sayan.productservice.dto.ProductRequest;
import com.sayan.productservice.dto.ProductResponse;
import com.sayan.productservice.helper.ProductHelper;
import com.sayan.productservice.model.Product;
import com.sayan.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved!", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductHelper::mapProductToResponse).toList();
    }
}