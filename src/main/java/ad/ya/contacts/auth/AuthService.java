package ad.ya.contacts.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final RestTemplate restTemplate;

    public AuthResponse login(Credentials credentials) {
        try {
            return restTemplate.postForObject("http://localhost:8080/auth/login",credentials, AuthResponse.class);
        } catch (Exception e) {
            throw new SecurityException("Invalid Credentials");
        }
    }

    public void register(RegisterDto user) {
        restTemplate.postForObject("http://localhost:8080/auth/register",user, String.class);
    }
}
