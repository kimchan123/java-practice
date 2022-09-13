package com.woowacourse.thread;

import javax.annotation.PostConstruct;

public class Counter extends Thread {

    @PostConstruct
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(System.currentTimeMillis());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
