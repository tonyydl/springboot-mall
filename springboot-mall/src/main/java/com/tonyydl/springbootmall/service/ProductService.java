package com.tonyydl.springbootmall.service;

import com.tonyydl.springbootmall.dto.ProductRequest;
import com.tonyydl.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
