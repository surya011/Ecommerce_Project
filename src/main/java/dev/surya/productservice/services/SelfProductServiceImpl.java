package dev.surya.productservice.services;

import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public String getProductById(Long Id){
      return "Hello self implemented class" +Id;
        //  return new Product();

    }
}
