package com.nikita.hohunskyi.application.config;

import com.nikita.hohunskyi.api.converter.service.ExtendedConversionService;
import com.nikita.hohunskyi.api.converter.service.ExtendedConversionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Configuration
@ComponentScan("com.nikita.hohunskyi.api.converter")
public class ConversionConfig {

    @Bean
    ExtendedConversionService extendedConversionService(List<Converter> converters) {
        ExtendedConversionServiceImpl bean = new ExtendedConversionServiceImpl();
        converters.forEach(bean::addConverter);
        return bean;
    }
}