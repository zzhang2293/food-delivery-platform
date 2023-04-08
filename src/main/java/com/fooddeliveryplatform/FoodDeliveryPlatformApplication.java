package com.fooddeliveryplatform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.util.AntPathMatcher;

@Slf4j
@SpringBootApplication
@ServletComponentScan
public class FoodDeliveryPlatformApplication {


    public static void main(String[] args) {
        SpringApplication.run(FoodDeliveryPlatformApplication.class, args);
        // these url does not need handle the request
        log.info("APPLICATION START ...");
    }



}
