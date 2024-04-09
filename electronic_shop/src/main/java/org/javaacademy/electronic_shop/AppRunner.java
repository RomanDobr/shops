package org.javaacademy.electronic_shop;
import org.javaacademy.tax.TaxService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class AppRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
        //AppRunner runner = context.getBean(AppRunner.class);
    }
}
