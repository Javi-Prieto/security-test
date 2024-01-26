package net.openwebinars.springboot.restjwt;

import net.openwebinars.springboot.restjwt.user.model.User;
import net.openwebinars.springboot.restjwt.user.model.UserRole;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;
import java.util.Set;

@TestConfiguration
public class SpringSecurityTestWebConfig {
    @Bean("customUserDetailsService")
    @Primary
    public UserDetailsService userDetailsService() {
        User admin = User.builder()
                .username("admin")
                .password("admin")
                .roles(Set.of(UserRole.ADMIN))
                .build();
        User user = User.builder()
                .username("user")
                .password("user")
                .roles(Set.of(UserRole.USER))
                .build();

        return new InMemoryUserDetailsManager(List.of(admin, user));
    }
}
