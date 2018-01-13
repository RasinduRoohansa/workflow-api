package com.spsolutions.grand.resources.finance;

import com.spsolutions.grand.domain.Tax;
import com.spsolutions.grand.service.finance.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/finance/")
public class FinanceAPI {

    @Autowired
    private FinanceService financeService;

    @GetMapping(value = "findSystemTax")
    public List<Tax> findSystemTax() {
        return this.financeService.findSystemTax();
    }

}
