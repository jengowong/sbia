package com.github.jengo.sbia;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link FloatingPointNumber}
 *
 * https://mp.weixin.qq.com/s/IeoduwUqWOiia2SQ0YMXLA
 */
@Slf4j
public class FloatingPointNumber {

    @Before
    public void before() {
        log.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
    }

    @After
    public void after() {
        log.info("↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }

    @Test
    public void test() {
        log.info("{}", Float.floatToRawIntBits(0.09f));
    }

}
