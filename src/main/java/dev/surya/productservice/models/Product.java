package dev.surya.productservice.models;
import jakarta.persistence.*;
import lombok.*;


//for Delombok press ctrl + shift+ a
//checking git remote
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name ="category")
    private Category category;
    //private double price;

    //With this change cascade now you don't have to save the price in db specifically
    // Added cascade remove to delete the price also if product is deleted
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Price price;

}
