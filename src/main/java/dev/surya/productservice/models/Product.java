package dev.surya.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//for Delombok press ctrl + shift+ a
public class Product extends BaseModel {
    private  String title;
    private String description;
    private  String image;
    private Category category;
    private  double price;
}
