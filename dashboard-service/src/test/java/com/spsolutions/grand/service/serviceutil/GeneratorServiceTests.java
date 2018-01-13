package com.spsolutions.grand.service.serviceutil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorServiceTests {

    @Autowired
    private GeneratorService generatorService;

    @Test
    public void generateId() {
//        System.out.println(this.generatorService.generateId(ServiceConstants.BOOKING_TYPE.getType()));
    }

}
