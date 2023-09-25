package dev.surya.productservice.thirdpartyclients.fakestore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long Id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
