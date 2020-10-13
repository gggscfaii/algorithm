package com.wsd.algorithm.jvm.anatomy.quarks.quarks1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * LockRoach
 *
 * @author wangshudong
 * @date 2020/6/27
 */
@Fork(jvmArgsPrepend = {"-XX:-UseBiasedLocking"})
@State(Scope.Benchmark)
public class LockRoach {
    int x;

    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void test() {
        for (int i = 0; i < 1000; i++) {
            synchronized (this) {
                x += 0x042;
            }
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(LockRoach.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
