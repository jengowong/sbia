package com.github.jengo.sbia;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = ReadingListApplicationTests.class)
@SpringBootTest
public class ReadingListApplicationTests {

    @Before
    public void before() {
        log.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
    }

    @After
    public void after() {
        log.info("↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }

    @Test //测试加载的上下文
    public void contextLoads() {
    }

}
