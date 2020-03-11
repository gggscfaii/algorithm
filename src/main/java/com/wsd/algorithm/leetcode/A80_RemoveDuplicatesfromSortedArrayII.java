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


    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;

        int pre = 0, cur = 1, n = nums.length;
        while (cur < n) {
            boolean hasRepeat = false;
            while (cur < n && nums[pre] == nums[cur]) {
                cur++;
                hasRepeat = true;
            }

            int preTemp = pre;
            int curTemp = cur;
            while (hasRepeat && curTemp < n) {
                nums[preTemp++] = nums[curTemp++];
            }

            if (curTemp >= n) {
                n = preTemp;
            }

            if (!hasRepeat) {
                pre++;
            }
            cur = pre + 1;
        }
        return pre < n ? pre + 1 : -1;
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));

        int[] ints = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates1(ints));
        ArrayUtil.print(ints);

        int[] ints1 = {1, 2, 3, 4, 5, 6};
        System.out.println(removeDuplicates1(ints1));
        ArrayUtil.print(ints1);

        int[] ints2 = {1, 1};
        System.out.println(removeDuplicates1(ints2));
        ArrayUtil.print(ints2);


    }

}
