package com.cac.g6.tpfinal.services;

import com.cac.g6.tpfinal.entities.Currency;
import com.cac.g6.tpfinal.entities.dto.CurrencyDto;
import com.cac.g6.tpfinal.mappers.CurrencyMapper;
import com.cac.g6.tpfinal.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(Long id) {
        return currencyRepository.findById(id).get();
    }

    public CurrencyDto createCurrency(CurrencyDto currencyDto) {
        Currency entity = CurrencyMapper.dtoToCurrency(currencyDto);
        Currency entitySaved = currencyRepository.save(entity);
        currencyDto = CurrencyMapper.currencyToDto(entitySaved);
        return currencyDto;
    }

}
