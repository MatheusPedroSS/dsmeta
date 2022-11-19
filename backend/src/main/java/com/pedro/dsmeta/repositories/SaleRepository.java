package com.pedro.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.dsmeta.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    
    Page<Sale> findByDateBetweenOrderByAmountDesc(LocalDate min, LocalDate max, Pageable pageable);

}
