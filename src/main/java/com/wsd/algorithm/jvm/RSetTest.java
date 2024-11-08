package com.wsd.algorithm.jvm;

public class RSetTest {
    static Object[] largeObject1 = new Object[1024 * 1024];
    static Object[] largeObject2 = new Object[1024 * 1024];
    static int[] temp;

    // -Xmx256M -XX:+UseG1GC -XX:G1ConcRefinementThreads=4 -XX:G1ConcRefinementGreenZone=1 -XX:G1ConcRefinementYellowZone=2 -XX:G1ConcRefinementRedZone=3 -XX:+UnlockExperimentalVMOptions -XX:G1LogLevel=finest -XX:+UnlockDiagnosticVMOptions -XX:+G1TraceConcRefinement -XX:+PrintGCTimeStamps
    public static void main(String[] args) {
        int numGCs = 200;
        for (int k = 0; k < numGCs - 1; k++) {
            for (int i = 0; i < largeObject1.length; i++) {
                largeObject1[i] = largeObject2;
            }
            for (int i = 0; i < largeObject2.length; i++) {
                largeObject2[i] = largeObject1;
            }
            for (int i = 0; i < 1024; i++) {
                temp = new int[1024];
            }
            System.gc();
        }
    }
}