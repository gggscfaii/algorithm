package com.wsd.algorithm.test4;

import org.apache.commons.lang.StringUtils;

public class XmTest {

    public static int compareVersion(String v1, String v2) {

        if (StringUtils.isEmpty(v1) && StringUtils.isEmpty(v2)) {
            return 0;
        }

        if (StringUtils.isNotEmpty(v1) && StringUtils.isEmpty(v2)) {
            return 1;
        }

        if (StringUtils.isEmpty(v1) && StringUtils.isNotEmpty(v2)) {
            return -1;
        }

        String[] v1s = v1.split("\\.");
        String[] v2s = v2.split("\\.");

        int index = 0;
        for (; index < v1s.length && index < v2s.length; index++) {

            int v1Num = Integer.parseInt(v1s[index]);
            int v2Num = Integer.parseInt(v2s[index]);
            if (v1Num == v2Num) {
                continue;
            }

            if (v1Num > v2Num) {
                return 1;
            } else {
                return -1;
            }
        }

        for (; index < v1s.length; index++) {
            int v1Num = Integer.parseInt(v1s[index]);
            if (v1Num != 0) {
                return 1;
            }
        }

        for (; index < v2s.length; index++) {
            int v2Num = Integer.parseInt(v2s[index]);
            if (v2Num != 0) {
                return -1;
            }
        }

        return 0;
    }

    public static void testSameVersion() {
        int value = compareVersion("1.0.0", "1.0.0");
        if (value != 0) {
            System.out.println("error testSameVersion");
        }
    }

    public static void testDoubleZeroSameVersion() {
        int value = compareVersion("1.00.0", "1.0.0");
        if (value != 0) {
            System.out.println("error testDoubleZeroSameVersion");
        }
    }

    public static void testSameVersion_gap_num() {
        int value = compareVersion("1.0.0", "1.0");
        if (value != 0) {
            System.out.println("error testSameVersion_gap_num");
        }

        value = compareVersion("0.1", "0.1.0");
        if (value != 0) {
            System.out.println("error testSameVersion_gap_num");
        }
    }

    public static void testV1GreatV2() {
        int value = compareVersion("1.1.0", "1.0.0");
        if (value != 1) {
            System.out.println("error testV1GreatV2");
        }
    }

    public static void testV1GreatV2_gap_num() {
        int value = compareVersion("1.1.1", "1.1");
        if (value != 1) {
            System.out.println("error testV1GreatV2_gap_num");
        }
    }

    public static void testV1LessV2() {
        int value = compareVersion("1.1.0", "1.2.0");
        if (value != -1) {
            System.out.println("error testV1LessV2");
        }
    }

    public static void testV1LessV2_gap_num() {
        int value = compareVersion("1.1", "1.1.1");
        if (value != -1) {
            System.out.println("error testV1LessV2_gap_num");
        }
    }

    public static void testAllEmpty() {
        int value = compareVersion("", "");
        if (value != 0) {
            System.out.println("error testAllEmpty");
        }
    }

    public static void testNotEqualsHasOneEmpty() {
        int value = compareVersion("1.1", "");
        if (value != 1) {
            System.out.println("error testNotEqualsHasOneEmpty");
        }

        value = compareVersion("", "1.1");
        if (value != -1) {
            System.out.println("error testNotEqualsHasOneEmpty");
        }
    }

    public static void main(String[] args) {
        testSameVersion();
        testSameVersion_gap_num();
        testDoubleZeroSameVersion();
        testV1GreatV2();
        testV1GreatV2_gap_num();
        testV1LessV2();
        testV1LessV2_gap_num();
        testAllEmpty();
        testNotEqualsHasOneEmpty();
    }
}
