package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/16.
 */
public class A84_LargestRectangleinHistogram {

    public static int largestRectangleArea(int[] heights) {

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i + 1 < heights.length && heights[i] < heights[i + 1]) {
                continue;
            }

            int minHeight = heights[i];
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                res = Math.max(res, (i - j + 1) * minHeight);
            }
        }
        return res;
    }

    public static int largestRectangleArea1(int[] heights) {
        if (heights.length == 0)
            return 0;

        /**
         * algo is to find for each height in heights, what's the left wall and right wall
         * in heights for which we can't form the longest contiguous rect
         * the max area for heights[i] would then be heights[i] * (right wall - left wall - 1)
         *
         * e.g.
         *                 #
         *               # #
         *               # #   #
         *           #   # # # #
         *           # # # # # #
         *             l i   r
         *  left wall would be the first height to left of i that is less than height[i]
         *  right wall would be the first height to right of i that is less than height[i]
         */

        int[] leftWall = new int[heights.length];
        leftWall[0] = -1;  //outside range by default
        for (int i = 1; i < heights.length; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left = leftWall[left];
            }
            leftWall[i] = left;
        }

        int[] rightWall = new int[heights.length];
        rightWall[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int right = i + 1;
            while (right <= heights.length - 1 && heights[right] >= heights[i]) {
                right = rightWall[right];
            }
            rightWall[i] = right;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (rightWall[i] - leftWall[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea1(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea1(new int[]{3, 4, 5, 3, 4, 5}));

    }

}
