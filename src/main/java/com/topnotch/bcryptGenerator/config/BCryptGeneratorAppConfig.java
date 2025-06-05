package com.topnotch.bcryptGenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.topnotch.bcryptGenerator.factory.PasswordEncoderFactory;
import com.topnotch.bcryptGenerator.model.HashingAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BCryptGeneratorAppConfig extends WebSecurityConfigurerAdapter {

    @Value("${hashing.algorithm:BCRYPT}")
    private String algorithmProperty;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().permitAll().and().csrf().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        HashingAlgorithm algorithm = HashingAlgorithm.valueOf(algorithmProperty.toUpperCase());
        return PasswordEncoderFactory.create(algorithm);
    }
}
