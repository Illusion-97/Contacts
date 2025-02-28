package ad.ya.contacts.interceptors;

import ad.ya.contacts.auth.UserSecurity;
import ad.ya.contacts.tools.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final RestTemplate restTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            String email = JwtUtils.extractUsername(token);
            UserDetails user = restTemplate.getForObject("http://localhost:8080/users/byEmail/"+email, UserSecurity.class);
            // Doit contenir : l'objet identifié (principal), le token ayant servi à l'identification, liste des accès de l'objet (rôles)
            Authentication auth = new UsernamePasswordAuthenticationToken(user,token, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        // Laisse SpringSecurity terminer la gestion de l'authentification
        filterChain.doFilter(request,response);
    }
}
