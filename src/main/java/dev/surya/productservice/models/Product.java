package dev.surya.productservice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class Product extends BaseModel {
    private  String title;
    private String description;
    private  String image;
    private Category category;
    private  double price;
}
