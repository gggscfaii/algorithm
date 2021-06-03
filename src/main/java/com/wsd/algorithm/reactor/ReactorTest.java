package com.wsd.algorithm.reactor;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * ReactorTest
 *
 * @author wangshudong
 * @date 2020/12/7
 */
public class ReactorTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Flux<Long> flux = Flux.interval(Duration.ofSeconds(1))
        //         .take(10);
        // flux.subscribe(aLong -> {
        //     System.out.println("subscriber1 ,value is " + aLong);
        // });
        //
        // // //加入第二个Subscriber之前，需要connect一下
        // flux.connect();
        //
        // Thread.sleep(5000);
        //
        // flux.subscribe(aLong -> {
        //     System.out.println("subscriber2 ,value is " + aLong);
        // });
        // flux.blockLast();


        // Flux<Integer> ints = Flux.range(1, 4)
        //         .map(i -> {
        //             if (i <= 3) return i;
        //             throw new RuntimeException("Got to 4");
        //         });
        // ints.subscribe(i -> System.out.println(i),
        //         error -> System.err.println("Error: " + error));

        // Flux<Integer> ints = Flux.range(1, 4);
        // ints.subscribe(i -> System.out.println(i),
        //         error -> System.err.println("Error " + error),
        //         () -> {System.out.println("Done");},
        //         s -> s.request(10));

        // Flux<String> flux =
        //         Flux.interval(Duration.ofMillis(250))
        //                 .map(input -> {
        //                     if (input < 3) return "tick " + input;
        //                     throw new RuntimeException("boom");
        //                 })
        //                 .onErrorReturn(t -> true,"oh no");
        //
        // flux.subscribe(System.out::println);
        // Thread.sleep(4100);

        // Mono<Object> just = Mono.just(1);
        //
        // Flux<String> flux = Flux.empty();
        // Mono<List<String>> mono = flux.collectList();
        // mono.subscribe(new Consumer<List<String>>() {
        //     @Override
        //     public void accept(List<String> strings) {
        //         System.out.println(strings);
        //     }
        // });
        //
        //
        // System.out.println(3%3);

        // Flux<Integer> flux = Flux.just(1, 3, 5);
        // Mono<List<Integer>> listMono = flux.filter(i -> i % 2 == 0).flatMap(i -> Mono.just(i * 2)).collectList();
        // System.out.println(listMono.toFuture().get());
        // listMono.subscribe(new Consumer<List<Integer>>() {
        //     @Override
        //     public void accept(List<Integer> integers) {
        //         System.out.println(integers);
        //     }
        // });

        // Mono<Integer> integerMono = Mono.fromSupplier(new Supplier<Integer>() {
        //     @Override
        //     public Integer get() {
        //
        //         try {
        //             Thread.sleep(2000L);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         return 5;
        //     }
        // });
        //
        // integerMono.subscribe(new Consumer<Integer>() {
        //     @Override
        //     public void accept(Integer integer) {
        //         System.out.println(integer);
        //     }
        // });
        //
        // System.out.println("123");

        System.out.println(Long.MAX_VALUE);
    }
}
