package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/15.
 */
public class A80_RemoveDuplicatesfromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int pre = 0, cur = 1, cnt = 1, n = nums.length;
        while (cur < n) {
            if (nums[pre] == nums[cur] && cnt == 0) ++cur;
            else {
                if (nums[pre] == nums[cur]) --cnt;
                else cnt = 1;
                nums[++pre] = nums[cur++];
            }
        }
        return pre + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

}
