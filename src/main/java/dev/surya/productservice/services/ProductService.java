package dev.surya.productservice.services;

import dev.surya.productservice.dtos.GenericProductDto;
import dev.surya.productservice.exceptions.NotFoundException;
import dev.surya.productservice.models.Product;

import java.util.List;

public interface ProductService {
    GenericProductDto createProduct(GenericProductDto product);

    //Product getProductById(Long Id);
    GenericProductDto getProductById(Long Id) throws NotFoundException;

    GenericProductDto updateProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);
}
