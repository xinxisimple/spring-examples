package com.xinxisimple.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

@Slf4j
public class Tests {

    @Test
    public void logback() {
        log.info("abc");
    }

    @Test
    public void utils() {
        System.out.println(StringUtils.isBlank(""));
    }
}
