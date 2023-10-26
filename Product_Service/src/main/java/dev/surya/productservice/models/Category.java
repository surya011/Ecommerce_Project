package dev.surya.productservice.models;

import io.micrometer.core.annotation.Counted;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel {
    @Column
    private  String name;

    @OneToMany( mappedBy = "category")
    // this is the same relation being mapped by other class product . this
    // will not create category_product table in db
    private List<Product> products = new ArrayList<>();


}
