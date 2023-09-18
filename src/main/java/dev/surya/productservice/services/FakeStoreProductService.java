package dev.surya.productservice.services;

import dev.surya.productservice.dtos.FakeStoreProductDto;
import dev.surya.productservice.dtos.GenericProductDto;
import dev.surya.productservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl ="https://fakestoreapi.com/products/{id}";

    private String productRequestsBaseUrl = "https://fakestoreapi.com/products";


    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();

        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity
                (productRequestsBaseUrl, product, GenericProductDto.class
                );
        return response.getBody();
    }

    @Override
    public GenericProductDto updateProduct(GenericProductDto product, Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto>response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        //product.setId(fakeStoreProductDto.getId());
        fakeStoreProductDto.setImage("new image url");
        fakeStoreProductDto.setDescription("changed description");
        fakeStoreProductDto.setTitle("new title");
        fakeStoreProductDto.setPrice(1100);
        fakeStoreProductDto.setCategory("new category");

       product = convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);

        return  createProduct(product);
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        //response.getStatusCode();

        if(fakeStoreProductDto == null) {
           throw new NotFoundException("Product with id : " + id + " doesn't exist" );
        }

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate =restTemplateBuilder.build();

        // since FakeStoreDto not available at run time , genrics are removed and converted to List.class
       ResponseEntity<FakeStoreProductDto[]> response   =
               restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class );

       List<GenericProductDto> answer = new ArrayList<>();

       for (FakeStoreProductDto fakeStoreProductDto: Arrays.stream(response.getBody()).toList()) {
           answer.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
       }
       return answer;

    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto>response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);

    }
}
