package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sdwang on 2020/2/9.
 */
public class A56_MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) {
            return intervals;
        }


        List<Interval> objIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            Interval objInterval = new Interval(interval[0], interval[1]);
            objIntervals.add(objInterval);
        }
        Collections.sort(objIntervals, (o1, o2) -> o1.start - o2.start);

        List<Interval> resultIntervals = new ArrayList<>();
        Interval curr = objIntervals.get(0);
        for (int i = 1, l = objIntervals.size(); i < l; i++) {
            Interval I = objIntervals.get(i);
            if (I.start >= curr.start
                    && I.start <= curr.end) { // check if the new interval overlaps with the current
                curr.end = curr.end > I.end ? curr.end : I.end;
            } else {
                resultIntervals.add(curr);
                curr = I;
            }
        }
        resultIntervals.add(curr);

        int[][] ss = new int[resultIntervals.size()][resultIntervals.size()];
        for (int i = 0, l = resultIntervals.size(); i < l; i++) {
            ss[i] = new int[]{resultIntervals.get(i).start, resultIntervals.get(i).end};
        }
        return ss;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        ArrayUtil.print(merge(intervals));

        intervals = new int[][]{{1, 4}, {0, 0}};
        ArrayUtil.print(merge(intervals));

        intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        ArrayUtil.print(merge(intervals));

    }
}
