package com.cts.productappreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
public class ProductAppReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductAppReactiveApplication.class, args);
    }

}
