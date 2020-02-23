package pl.pongut.shop.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.jwt")
@Getter
@Setter
public class JwtConfig {
    private String tokenHeader = "Authorization";
    private String tokenPrefix = "Bearer ";
    private int tokenValidityMilis = 86400000;
    private String secret;
}
