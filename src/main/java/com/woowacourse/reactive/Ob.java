package com.woowacourse.reactive;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("deprecation")
public class Ob {

    /**
     * 이러한 방식의 옵저버 패턴에는 2가지의 문제가 있다. 1. Complete -> 완료의 개념이 없다. notifyObservers 메서드 밖에 없기 때문 2. Error -> 비동기적으로 구현하게 되면
     * Error Handling이 어려워진다.
     */

    static class IntObservable extends Observable implements Runnable {

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                setChanged();
                notifyObservers(i);
            }
        }
    }

    //DATA method(void) : pull 방식 <-> void method(DATA) : push 방식
    public static void main(String[] args) {
        Observer ob = new Observer() {
            @Override
            public void update(final Observable o, final Object arg) {
                System.out.println(Thread.currentThread().getName() + " " + arg);
            }
        };

        IntObservable io = new IntObservable();
        io.addObserver(ob);

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(io);

        System.out.println(Thread.currentThread().getName() + " EXIT");
        es.shutdown();
    }
}
