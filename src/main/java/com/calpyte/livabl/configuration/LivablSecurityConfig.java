package com.calpyte.livabl.configuration;
//
//import com.keycloak.connector.security.IAMKeycloakSecurityConfig;
//import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@Order(1)
//@EnableWebSecurity
//public class LivablSecurityConfig extends IAMKeycloakSecurityConfig {
//    private static final String RESOURCES = "/resources/**";
//    private static final String SWAGGER_UI_HTML = "/swagger-ui.html";
//    private static final String SWAGGER_UI = "/swagger-ui/**";
//    private static final String API_DOCS = "/api-docs/**";

//    public LivablSecurityConfig(KeycloakClientRequestFactory keycloakClientRequestFactory) {
//        super(keycloakClientRequestFactory);
//    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(RESOURCES, SWAGGER_UI_HTML, SWAGGER_UI, API_DOCS,"/unsecure/**", "/unsecure/access/token" );
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().sessionManagement().
//                sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
//                authorizeRequests().anyRequest().permitAll();
//    }

//}
