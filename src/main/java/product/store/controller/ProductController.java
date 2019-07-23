package product.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import product.store.entity.Product;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(produces = {APPLICATION_JSON_VALUE})
@RestController
public class ProductController {

    @ApiOperation("Product API")
    @GetMapping(path = "products")
    public List<Product> getProducts() throws RuntimeException {
        throw new RuntimeException("Not Implemented yet... :(");
    }
}
