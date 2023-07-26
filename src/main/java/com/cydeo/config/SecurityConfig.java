package com.cydeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder){
//                List<UserDetails> userList =  new ArrayList<>();
//
//        userList.add(
//                new User("mike", encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
//        userList.add(
//                new User("ozzy", encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_MANAGER"))));
//
//
//        return new InMemoryUserDetailsManager(userList);
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
//                .antMatchers("/user/**").hasRole("Admin")
                .antMatchers("/user/**").hasAuthority("Admin")
                .antMatchers("/project/**").hasRole("Manager")
                .antMatchers("/task/employee/**").hasRole("Employee")
                .antMatchers("/task/**").hasRole("Employee")
                //.antMatchers("/task/**").hasAnyRole("EMPLOYEE","ADMIN")
                //.antMatchers("/task/**").hasAuthority("ROLE_EMPLOYEE")
                .antMatchers(
                        "/",
                        "/login",
                        "fragments/**",
                        "/assets/**",
                        "/images/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/welcome")
                    .failureUrl("/login?error=true")
                //.httpBasic()
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and().build();

    }
}
