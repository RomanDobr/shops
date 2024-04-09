package org.javaacademy.coffee_shop.shop;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.tax.TaxService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class CoffeeShop {
    private static final Integer ONE_CUP_COFFEE_GRAMS = 30;
    private static final Integer BUY_SIZE = 10_000;
    private static final String COFFEE_SHOP_NAME = "Y YIRY";
    private Integer coffeeWeightGrams = 0;
    private final TaxService taxService;
    @PostConstruct
    public void init() {
       buyCoffee();
       log.info(sellCoffee(CoffeeType.AMERICANO).toString());
        log.info(sellCoffee(CoffeeType.AMERICANO).toString());
       log.info(" Количество кофе на складе: {}", coffeeWeightGrams);
    }
    public Coffee sellCoffee(CoffeeType order) {
        if (coffeeWeightGrams < ONE_CUP_COFFEE_GRAMS) {
            throw new RuntimeException("Нету кофе на складе");
        }
        coffeeWeightGrams -= ONE_CUP_COFFEE_GRAMS;
        BigDecimal taxCount = TaxService.TAX_FARE.multiply(new BigDecimal(order.getPrice()));
        taxService.payTax(COFFEE_SHOP_NAME, taxCount);
        return new Coffee(order);
    }
    public void buyCoffee() {
        coffeeWeightGrams += BUY_SIZE;
    }
}
