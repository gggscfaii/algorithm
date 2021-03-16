package com.wsd.algorithm.reactor;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * ReactorTest
 *
 * @author wangshudong
 * @date 2020/12/7
 */
public class ReactorTest {

    public static void main(String[] args) throws InterruptedException {
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


        Flux<String> flux = Flux.empty();
        Mono<List<String>> mono = flux.collectList();
        mono.subscribe(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) {
                System.out.println(strings);
            }
        });
    }
}
