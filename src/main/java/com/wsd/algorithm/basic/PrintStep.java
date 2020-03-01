package com.wsd.algorithm.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sdwang on 2020/2/27.
 */
public class PrintStep {

    public static List<List<Integer>> printStep(int step, Map<Integer, List<List<Integer>>> memo) {

        List<List<Integer>> memoSteps = memo.get(step);
        if (memoSteps != null) {
            return memoSteps;
        }

        List<List<Integer>> steps = new ArrayList<>();

        if (step == 1) {
            List<Integer> subSteps = new ArrayList<>();
            subSteps.add(1);
            steps.add(subSteps);
            memo.put(step, steps);
            return steps;
        }

        if (step == 2) {
            List<Integer> subSteps = new ArrayList<>();
            subSteps.add(1);
            subSteps.add(1);
            steps.add(subSteps);

            subSteps = new ArrayList<>();
            subSteps.add(2);
            steps.add(subSteps);
            memo.put(step, steps);
            return steps;
        }

        List<List<Integer>> sub1 = printStep(step - 1, memo);
        for (List<Integer> sub : sub1) {
            List<Integer> newSub = new ArrayList<>();
            newSub.add(1);
            newSub.addAll(sub);
            steps.add(newSub);
        }

        List<List<Integer>> sub2 = printStep(step - 2, memo);
        for (List<Integer> sub : sub2) {
            List<Integer> newSub = new ArrayList<>();
            newSub.add(2);
            newSub.addAll(sub);
            steps.add(newSub);
        }

        memo.put(step, steps);
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(printStep(10, new HashMap<>()));
    }
}
