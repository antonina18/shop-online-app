package pl.pongut.shop.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TokenObject {
    private String accessToken;
}
