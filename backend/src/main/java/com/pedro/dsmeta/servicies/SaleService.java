package com.pedro.dsmeta.servicies;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pedro.dsmeta.entities.Sale;
import com.pedro.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
    
    @Autowired
    private SaleRepository repository;

    public Page<Sale> findSales(Pageable pageable, String minDate, String maxDate) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("")
                ? today.minusYears(1L)
                : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("")
                ? today
                : LocalDate.parse(maxDate);

        return repository.findByDateBetweenOrderByAmountDesc(min, max, pageable);
    }

}
