package com.woowacourse.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Test
    void test() {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Thread1 implements Runnable {

        private MemberService memberService;

        @Override
        public void run() {
            memberService.findMember(1L);
            memberService.findMember(1L);
        }
    }

    class Thread2 implements Runnable {

        private MemberService memberService;

        @Override
        public void run() {
            memberService.changeName(1L, "changedName");
        }
    }
}
