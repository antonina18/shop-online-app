package pl.pongut.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pongut.shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
