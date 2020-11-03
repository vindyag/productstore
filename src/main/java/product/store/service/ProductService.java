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
        return productRepository.findById(id);
    }

    public Product getProductByProductCode(String productcode) {
        return productRepository.findByProductCode(productcode);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProductByProductId(Long productId) {
        try {
            productRepository.deleteById(productId);
            return true;
        } catch (EmptyResultDataAccessException ex) {
        }
        return false;
    }
}
