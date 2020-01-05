package pl.pongut.shop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.pongut.shop.model.Product;
import pl.pongut.shop.repository.ProductRepository;

import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
@Slf4j
public class DatabaseInitializer implements CommandLineRunner {

    private ProductRepository productRepo;

    public DatabaseInitializer(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepo.saveAll(List.of(
                new Product(1, "MacBook Air", 2100.0f),
                new Product(2, "Bułka pszenna", 0.50f),
                new Product(3, "Pokarm dla chomików", 7.50f)
        ));

        log.info("Database initialized.");
    }
}
