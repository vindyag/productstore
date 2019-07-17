package product.store.repository;

import org.springframework.data.repository.CrudRepository;
import product.store.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>
{

}