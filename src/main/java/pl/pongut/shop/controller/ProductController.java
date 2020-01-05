package pl.pongut.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pongut.shop.model.Product;
import pl.pongut.shop.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    private ProductRepository repo;

    @PostMapping(path = "/add")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(product));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<Iterable<Product>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
    }
}
