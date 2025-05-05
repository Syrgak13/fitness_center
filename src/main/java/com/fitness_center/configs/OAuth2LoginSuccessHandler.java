package com.fitness_center.configs;

import com.fitness_center.entities.User;
import com.fitness_center.entities.Role;
import com.fitness_center.repositories.UserRepository;
import com.fitness_center.service.JwtService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        Optional<User> userOptional = userRepository.findByEmail(email);
        User user;

        if (userOptional.isEmpty()) {
            user = User.builder()
                    .email(email)
                    .username(name)
                    .password("") // OAuth2 users may not use password
                    .role(Role.USER)
                    .build();
            userRepository.save(user);
        } else {
            user = userOptional.get();
        }

        String token = jwtService.generateToken(user);
        response.sendRedirect("/auth/oauth2/success?token=" + token);
    }
}