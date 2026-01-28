package com.example.api_bakery.configuration;

// import org.springframework.boot.web.servlet.FilterRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.Ordered;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;

// @Configuration
// public class CorsConfig {
//     @Bean
//     public FilterRegistrationBean customCorsFilter() {
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         CorsConfiguration config = new CorsConfiguration();
//         //   config.setAllowCredentials(true);
//         config.addAllowedOrigin("*");
//         config.addAllowedHeader("*");
//         config.addAllowedMethod("*");
//         source.registerCorsConfiguration("/", config);
//         FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//         bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//         return bean;
//     }
// }
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class CorsConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> customCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow all origins, headers, and methods for testing
        config.addAllowedOriginPattern("*"); // Use addAllowedOriginPattern for wildcard matching in Spring Boot >= 2.4.0
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true); // Allow credentials if needed

        // Apply this configuration to all endpoints
        source.registerCorsConfiguration("/**", config);

        // Register the CorsFilter
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE); // Set filter to have the highest precedence
        return bean;
    }
}
