package com.cac.g6.tpfinal.mappers;

import com.cac.g6.tpfinal.entities.Currency;
import com.cac.g6.tpfinal.entities.dto.CurrencyDto;


public class CurrencyMapper {

    public static Currency dtoToCurrency(CurrencyDto dto){
        Currency currency = new Currency();
        currency.setCode(dto.getCode());
        currency.setName(dto.getName());
        return currency;
    }

    public static CurrencyDto currencyToDto(Currency currency){
        CurrencyDto dto = new CurrencyDto();
        dto.setIdCurrencyDto(currency.getIdCurrency());
        dto.setName(currency.getName());
        dto.setCode(currency.getCode());
        return dto;
    }

}
