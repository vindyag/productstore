package product.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import product.store.entity.Product;
import product.store.service.ProductService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value="products", produces = {APPLICATION_JSON_VALUE})
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation("Retrieve All Products in the System")
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @ApiOperation("Create a new Product in the System")
    @PostMapping
    public Product createProduct(
        @ApiParam(value = "Details of the new Product")
        @RequestBody Product product) {
        return productService.createProduct(product);
    }

    @ApiOperation("Retrieves a Product in the System")
    @GetMapping(path="/{productId}")
    public ResponseEntity<Product> getProduct(
        @ApiParam(value = "Product Id to retrieve")
        @PathVariable Long productId) {

        Product product = productService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @ApiOperation("Deletes a Product in the System")
    @DeleteMapping(path="/{productId}")
    public ResponseEntity<String> deleteProduct(
            @ApiParam(value = "Product Id to delete")
            @PathVariable Long productId) {

        boolean  isDeleted = productService.deleteProductByProductId(productId);

        if (isDeleted) {
            return ResponseEntity.ok().body("Successfully deleted Product");
        } else {
            return new ResponseEntity<>("Error in deleting Product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
