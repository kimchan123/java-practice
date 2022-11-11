package com.woowacourse.reactive;

import java.util.Arrays;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class PubSub {
    public static void main(String[] args) {
        //Publisher <- Observable
        //Subscriber <- Observer
        Iterable<Integer> itr = Arrays.asList(1, 2, 3, 4, 5);

        Publisher p = new Publisher() {
            @Override
            public void subscribe(final Subscriber subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    @Override
                    public void request(final long n) {
                        
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };

        Subscriber<Integer> s = new Subscriber<Integer>() {

            @Override
            public void onSubscribe(final Subscription subscription) {

            }

            @Override
            public void onNext(final Integer item) {

            }

            @Override
            public void onError(final Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

        p.subscribe(s);
    }
}
