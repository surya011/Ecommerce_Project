package dev.surya.productservice.thirdpartyclients.fakestore;

import dev.surya.productservice.dtos.GenericProductDto;
import dev.surya.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
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

/***
 * wrapper over Fakestore
 */
@Service
public class FakeStoryProductServiceClient {

    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreApiurl;

    @Value("${fakestore.api.url}")
    private String fakeStoreProductApiPath;

    private String specificProductRequestUrl;
    private String productRequestsBaseUrl;



    public FakeStoryProductServiceClient(RestTemplateBuilder restTemplateBuilder,
                                         @Value("${fakestore.api.url}") String fakeStoreApiurl,
                                         @Value("${fakestore.api.paths.product}") String fakeStoreProductApiPath){
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestsBaseUrl  = fakeStoreApiurl + fakeStoreProductApiPath;
        this.specificProductRequestUrl = fakeStoreApiurl + fakeStoreProductApiPath + "/{id}";
    }


    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity
                (productRequestsBaseUrl, product, FakeStoreProductDto.class
                );
        return response.getBody();
    }


    public FakeStoreProductDto updateProduct(Long id, GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.PUT, requestCallback, responseExtractor, id, product);

        return response.getBody();

    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        //response.getStatusCode();

        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id : " + id + " doesn't exist" );
        }

        return fakeStoreProductDto;

    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate =restTemplateBuilder.build();

        // since FakeStoreDto not available at run time , genrics are removed and converted to List.class
        ResponseEntity<FakeStoreProductDto[]> response   =
                restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class );

        List<GenericProductDto> answer = new ArrayList<>();

        return Arrays.stream(response.getBody()).toList();

    }


    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto>response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return response.getBody();



    }
}
