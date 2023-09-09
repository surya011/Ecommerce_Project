package dev.surya.productservice.services;

import dev.surya.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("fakeProductService")
public class FakeStoreProductService implements ProductService{

//    @Override
//    public Product getProductById(Long Id) {
//        return new Product();
        //return null;
    @Override
    public String getProductById(Long Id){
        return null;

    }
}
