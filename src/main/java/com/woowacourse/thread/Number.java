package com.woowacourse.thread;

public class Number extends Thread {

    private int value = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            value++;
            System.out.println(value);
        }
    }
}
