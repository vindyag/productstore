package product.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import product.store.entity.Product;
import product.store.service.ProductService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(produces = {APPLICATION_JSON_VALUE})
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation("Retrieve All Products in the System")
    @GetMapping(path = "products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}
