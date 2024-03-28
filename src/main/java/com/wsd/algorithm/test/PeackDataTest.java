package com.wsd.algorithm.test;

public class PeackDataTest {

    public static int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length;
        while (low < high) {

            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int nums[] = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));

//        nums[] = {1, 2, 3, 1};
    }
}
