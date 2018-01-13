package com.spsolutions.grand.service.finance;

import com.spsolutions.grand.domain.Tax;
import com.spsolutions.grand.mappers.finance.FinanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {

    @Autowired
    private FinanceMapper financeMapper;

    public List<Tax> findSystemTax() {
        return this.financeMapper.findSystemTax();
    }
}
