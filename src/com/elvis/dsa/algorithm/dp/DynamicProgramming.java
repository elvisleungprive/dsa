package com.elvis.dsa.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;

public class DynamicProgramming {
    public int coinChange_Q322(int[] coins, int amount) {
        HashMap<Integer, Integer> dict = new HashMap<>();

        for (int i = 1; i <= amount; i++) {
            if (dict.containsKey(i))
                continue;
            else if (Arrays.asList(coins).contains(i)) {
                dict.put(i, 1);
                continue;
            }

            for (int key : dict.keySet()) {
                if (i % key == 0) {
                    dict.put(i, dict.get(key) * (i / key));
                }
            }
            for (int key : dict.keySet()) {
                for (int c : coins) {
                    if (c + dict.get(key) == i)
                        dict.put(i, dict.get(key) + 1);
                }
            }


        }
        return dict.get(amount);
    }
}
