package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A6_ZigZagConversion
 * Created by sdwang on 2019/9/9 11:15.
 * <p>
 * 1.预先定义好位置，依次添入空间
 * 2.逐行遍历,计算点位
 */
public class A6_ZigZagConversion {

    public static void main(String[] args) {

        System.out.println(convert1("PAYPALISHIRING", 2));
        System.out.println(convert1("PAYPALISHIRING", 3));
        System.out.println(convert1("PAYPALISHIRING", 4));

        System.out.println(convert2("PAYPALISHIRING", 2));
        System.out.println(convert2("PAYPALISHIRING", 3));
        System.out.println(convert2("PAYPALISHIRING", 4));

    }

    public static String convert1(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows <= 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static String convert2(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows <= 1) {
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int cycleLen = numRows * 2 - 2;
        int n = s.length();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(i + j));

                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
