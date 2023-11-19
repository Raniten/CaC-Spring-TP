package com.cac.g6.tpfinal.repositories;

import com.cac.g6.tpfinal.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository <Currency, Long> {
}
