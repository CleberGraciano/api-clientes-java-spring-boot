package org.github.cleberGraciano.clientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfiguration {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/api/usuarios").permitAll()
                    .antMatchers(
                            "/v1/customers/**",
                                      "/v1/services-provided/**").authenticated()
                    .anyRequest().denyAll();
    }
}
