package dev.surya.productservice.services;

import dev.surya.productservice.dtos.GenericProductDto;
import dev.surya.productservice.models.Product;

public interface ProductService {
    //Product getProductById(Long Id);
    GenericProductDto getProductById(Long Id);
}
