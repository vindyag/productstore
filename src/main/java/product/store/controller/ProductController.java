package product.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import product.store.entity.Product;
import product.store.service.ProductService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(produces = {APPLICATION_JSON_VALUE})
@RestController
public class ProductController {

    private static final String RESPONSE_MESSAGE_KEY = "message";
    private static final String RESPONSE_MESSAGE_SUCCESS_VALUE = "product deleted";
    private static final String RESPONSE_MESSAGE_FAILED_VALUE = "product delete failed";

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation("Retrieve All Products in the System")
    @GetMapping(path = "products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @ApiOperation("Create a new Product in the System")
    @PostMapping(path = "products")
    public Product createProduct(
        @ApiParam(value = "Details of the new Product")
        @RequestBody Product product) {
        return productService.createProduct(product);
    }

    @ApiOperation("Deletes a Product in the System")
    @DeleteMapping(path = "products")
    public ResponseEntity<?> deleteProduct(
            @ApiParam(value = "the Product to delete")
            @RequestBody Product product) {
        boolean isDeleted = false;
        Map<String, Object> result = new HashMap<>();
        try {
            isDeleted = productService.deleteProductByProductCode(product);
        } catch (Exception ex) {
            throw ex;
        }

        if (isDeleted) {
            result.put(RESPONSE_MESSAGE_KEY, RESPONSE_MESSAGE_SUCCESS_VALUE);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            result.put(RESPONSE_MESSAGE_KEY, RESPONSE_MESSAGE_FAILED_VALUE);
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
