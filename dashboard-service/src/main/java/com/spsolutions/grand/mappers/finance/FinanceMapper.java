package com.spsolutions.grand.mappers.finance;

import com.spsolutions.grand.domain.Tax;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FinanceMapper {
    List<Tax> findSystemTax();
}
