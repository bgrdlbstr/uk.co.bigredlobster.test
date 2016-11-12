package uk.co.bigredlobster.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        log.info("args {}", Arrays.toString(args));
    }
}
