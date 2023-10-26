package dev.surya.productservice;


import dev.surya.productservice.inheritancedemo.joinedtable.MentorRepository;
import dev.surya.productservice.inheritancedemo.joinedtable.UserRepository;
import dev.surya.productservice.models.Category;
import dev.surya.productservice.models.Price;
import dev.surya.productservice.models.Product;
import dev.surya.productservice.repositories.CategoryRepository;
import dev.surya.productservice.repositories.PriceRepository;
import dev.surya.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.UUID;
import java.util.List;

@SpringBootApplication
public class ProductserviceApplication {
    //implements CommandLineRunner {

    // commenting all to implement SelfProductService
//    private MentorRepository mentorRepository;
//    private UserRepository userRepository;
//
//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final   PriceRepository priceRepository;
//
//
//    public ProductserviceApplication(@Qualifier("jt_mr") MentorRepository mentorRepository,
//                                     @Qualifier("jt_ur") UserRepository userRepository,
//                                     ProductRepository productRepository,
//                                     CategoryRepository categoryRepository,
//                                     PriceRepository priceRepository) {
//        this.mentorRepository = mentorRepository;
//        this.userRepository = userRepository;
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//
//    }
//
    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
////        Mentor mentor = new Mentor();
////        mentor.setName("Surya");
////        mentor.setEmail("surya@gmail.com");
////        mentor.setAverageRating(4.65);
////        mentorRepository.save(mentor);
////
////        User user = new User();
////        user.setName("Aman");
////        user.setEmail("amancool@gmail.com");
////        userRepository.save(user);
//
//        Category category = new Category();
//        category.setName("Apple devices");
//       // Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price("Rupee",10);
//        //Price savedPrice = priceRepository.save(price);
//
//
//        Product product = new Product();
//        product.setTitle("Iphone 15 Pro");
//        product.setDescription("The Best Iphone Ever");
//
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
//
//        productRepository.deleteById(UUID.fromString("d73bfa46-47a5-4da4-a34a-6d7fd1263404"));
//
//        System.out.println(productRepository.countAllByPrice_Currency("Rupee"));
//
//        List<Product> products = productRepository.findAllByPrice_Currency("Rupee");
//
//        List<Product> prd = productRepository.findAllByName("Iphone 15 Pro");


    // After saving this product i got category id from the category table


//        Category category1 = categoryRepository.findById(UUID.fromString("130bf2f8-bbf4-4d5e-b3b3-820edcad37d4")).get();
//
//        System.out.println("Category name is: " + category1.getName());
//        System.out.println("Printing all products in the category");
//        Thread.sleep(1000);


//        for (Product product1 : category1.getProducts()) {
//            try {
//                System.out.println(product1.getTitle());
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//}
}
