package com.techatpark.gurukulams;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public interface QuestionExtractor {
    static void main(String args[]) {
        // Create publisher
        Publisher<Integer> publisherSync = subscriber -> {
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " | Publishing = " + i);
                subscriber.onNext(i);
            }
            subscriber.onComplete();
        };
        Subscriber<Integer> subscriberSync = new Subscriber<>() {   // Create subscriber
            @Override
            public void onSubscribe(Subscription subscription) {
            }

            @Override
            public void onNext(Integer item) {
                System.out.println(Thread.currentThread().getName() + " | Received = " + item);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onComplete() {
            }
        };
        publisherSync.subscribe(subscriberSync);
    }
}
