package org.javaacademy.tax;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TaxService {
    private Map<String, BigDecimal> taxByCompanies = new HashMap<>();
    public static final BigDecimal TAX_FARE = new BigDecimal("0.2");

    public void payTax(String nameCompany, BigDecimal taxCount) {
        BigDecimal taxesBefore = taxByCompanies.getOrDefault(nameCompany, BigDecimal.ZERO);
        taxByCompanies.put(nameCompany, taxesBefore.add(taxCount));
        log.info(taxByCompanies.toString());
    }
}
