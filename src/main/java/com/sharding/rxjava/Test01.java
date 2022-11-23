package com.sharding.rxjava;

import java.util.concurrent.PriorityBlockingQueue;

public class Test01 {
    public static void main(String[] args) {
        //producer
       // Observable<String> observable = Observable.just("how", "to", "do", "in", "java");
  //  observable.map(String::toUpperCase).subscribe(System.out::println);
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        queue.add(1);
        queue.add(5);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //Attaching producer to consumer


        //     .
    }
}
