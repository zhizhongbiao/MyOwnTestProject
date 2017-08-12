package com.example.yang.myapplication.base.mvp.payment;

import java.util.Random;

public class RandomGenerator {

    private Random rand;
    private StringBuffer stringBuffer = new StringBuffer();

    public RandomGenerator() {
        rand = new Random(System.currentTimeMillis());
    }

    public int[] next() {
        int[] ret = new int[4];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = rand.nextInt(10);
        }
        return ret;
    }

    public String getFourString() {
        for (int i = 0; i < next().length; i++) {
            stringBuffer.append(next()[i]);
        }

        return stringBuffer.toString();
    }
}
