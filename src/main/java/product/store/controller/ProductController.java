package product.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import product.store.entity.Product;

@RestController
public class ProductController {

    @GetMapping(value="products/")
    public List<Product> getProducts() throws RuntimeException {
        throw new RuntimeException("Not Implemented");
    }
}
