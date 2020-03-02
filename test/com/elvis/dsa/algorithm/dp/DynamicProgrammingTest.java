package com.elvis.dsa.algorithm.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicProgrammingTest {

    DynamicProgramming dp = new DynamicProgramming();

    @Test
    void coinChange_Q322() {
        assertEquals(3, dp.coinChange_Q322(new int[]{1, 2, 5}, 11));
    }
}