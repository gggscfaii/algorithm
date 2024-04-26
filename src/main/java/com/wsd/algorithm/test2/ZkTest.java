package com.wsd.algorithm.test2;

public class ZkTest {

    public static void main(String[] args) {

        int nums[] = new int[]{
                0, 1, 4, 6, 7, 10
        };
        int diff = 3;

        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (nums[j] - nums[i] != diff) {
                    continue;
                }

                for (int k = j + 1; k < n; k++) {

                    if (nums[k] - nums[j] != diff) {
                        continue;
                    }

                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
