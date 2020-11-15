package product.store.service;

import org.springframework.dao.EmptyResultDataAccessException;
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

    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProductByProductId(Long productId) {
        try {
            productRepository.deleteById(productId);
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
        return true;
    }
}
