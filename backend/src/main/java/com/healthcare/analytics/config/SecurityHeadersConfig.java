package com.healthcare.analytics.config;

import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.header.writers.HstsHeaderWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityHeadersConfig {

    @Bean
    public HeaderWriterFilter headerWriterFilter() {
        return new HeaderWriterFilter(new HstsHeaderWriter());
    }
}
