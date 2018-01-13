package com.spsolutions.grand.service.serviceutil;

import com.spsolutions.grand.domain.SystemIDGenerator;
import com.spsolutions.grand.mappers.mapperutil.GeneratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

@Service
public class GeneratorService {

    @Autowired
    private GeneratorMapper generatorMapper;

    public String generateId(String type) {
        SystemIDGenerator idGenerator = this.generatorMapper.findSystemIDGenerator(type);
        idGenerator.setNumber(idGenerator.getNumber() + 1);

        this.generatorMapper.updateSystemIDGenerator(idGenerator);

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumIntegerDigits(5);
        numberFormat.setGroupingUsed(false);

        if (idGenerator.getCharacter() != null) {
            return idGenerator.getCharacter().concat(numberFormat.format(idGenerator.getNumber()));
        }
        return numberFormat.format(idGenerator.getNumber());
    }
}
