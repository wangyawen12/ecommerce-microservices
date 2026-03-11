package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.Product;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductRequest productRequest);
    public List<ProductResponse> getAllProducts();



}
