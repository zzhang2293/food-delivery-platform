package com.fooddeliveryplatform.config;

import com.fooddeliveryplatform.transform.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * set static source mapper html
     * @param registry use to set mapper
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("START STATIC RESOURCE MAPPING ... ");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
    }

    /**
     * extend mvc message converter, convert the date into string,
     * convert the id fromm long into string so there is no data lose
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // create a new message converter object
        log.info("CONVERTER OPEN ... ");
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        // set object converter, the implementation is based on jackson, it converts java into jackson
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        converters.add(0, messageConverter);

    }
}
