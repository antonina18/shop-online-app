package pl.pongut.shop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.pongut.shop.model.Product;
import pl.pongut.shop.model.User;
import pl.pongut.shop.repository.ProductRepository;
import pl.pongut.shop.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
@Slf4j
public class DatabaseInitializer implements CommandLineRunner {

    private ProductRepository productRepo;
    private UserRepository userRepo;

    public DatabaseInitializer(ProductRepository productRepo,
                               UserRepository userRepo) {
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        addProducts();
        addUsers();

        log.info("Database initialized.");
    }

    private void addUsers() {
        String encodedPassword = "$2a$10$BQ.QGDi9oiZ/eRB5RZlUPurXRYMV96U5ZmGceOnpJ4nrCDbV8Yu1y"; // kotu123
        userRepo.saveAll(List.of(
                new User(1, "user", encodedPassword)
        ));
    }

    private void addProducts() {
        productRepo.saveAll(List.of(
                new Product(1, "MacBook Air", new BigDecimal(2100.0)),
                new Product(2, "Bułka pszenna", new BigDecimal(0.50f)),
                new Product(3, "Pokarm dla chomików", new BigDecimal(7.50f))
        ));
    }
}
