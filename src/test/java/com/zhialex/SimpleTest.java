package com.zhialex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTest {

    @Test
    void test1() {
        assertTrue(3 > 1);
    }

    @Test
    void test2() {
        assertTrue(3 > 3);
    }

    @Test
    void test3() {
        throw new NullPointerException();
    }
}
