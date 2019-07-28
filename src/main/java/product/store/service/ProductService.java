package product.store.service;

import org.springframework.stereotype.Service;

import java.util.List;

import product.store.entity.Product;
import product.store.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
