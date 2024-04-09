package org.javaacademy.tax;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.javaacademy.tax")
public class TaxConfig {

    @PostConstruct
    public void init() {
        System.out.println("------------------------------------------");
        System.out.println("Конфиг подняли");
        System.out.println("-------------------------------------------");
    }
}
