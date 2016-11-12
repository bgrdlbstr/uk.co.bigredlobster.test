package uk.co.bigredlobster.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestTest {
    private static final Logger log = LoggerFactory.getLogger(TestTest.class);

    @Test
    public void SomeTest() {
        log.info("Testy test");
        assertThat(1, is(1));
    }
}