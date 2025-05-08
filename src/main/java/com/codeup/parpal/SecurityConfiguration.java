package com.codeup.parpal;
import com.codeup.parpal.models.User;
import com.codeup.parpal.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/profile") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page
                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/")
                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeHttpRequests()

                .requestMatchers("/","/home","/about-us", "/sign-up", "/map/**", "/js/**","/css/**", "/imgs/**", "/calendar",
                        "/calendar/**"  ) // anyone can see the home and the ads pages

                .permitAll()
                /* Pages that require authentication */
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/events/**",
                        "/",
                        "/profile",
                        "/events/create-event",
                        "/home",
                        "/about-us",
                        "/calendar",
                        "/img/**",
                        "/calendar/**",
                        "/js/**",
                        "/map/",
                        "/css/**",
                        "/users/{id}/edit",
                        "/users/{id}/profile",
                        "/users/{id}/delete",
                        "/imgs/**",
                        "/users/**",
                        "/deleteEvent/**",
                        "/events/{id}/edit",
                        "/pals/index",
                        "/pals/{palID}/add",
                        "/pals/{palId}/remove",
                        "/users/all-users",
                        "/events/user-home",
                        "/user-events",
                        "/events/myEvents",
                        "/myEvents",
                        "/userEvents",
                        "/userEvents/{eventId}/remove",
                        "/userEvents/{eventId}/add",

                        "/pals",
                        "/pals/**",
                        "/users/all-users"

                        // only authenticated users can create ads
                        // only authenticated users can edit ads

                )
                .authenticated()
        ;
        return http.build();
    }
}