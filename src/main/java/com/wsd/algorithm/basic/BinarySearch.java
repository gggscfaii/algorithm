package com.wsd.algorithm.basic;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1,5};
        int v = 0;
        System.out.print(binarySearch(a, 3));
    }

    public static int binarySearch(int[] a, int k) {
        int l = 0;
        int r = a.length - 1;
        //标注1： 这里是l<r，
        while (l < r) {
            //标注2： 这样的操作是为了取高位
            int mid = (l + r + 1) / 2;
            if (a[mid] <= k) { //标注3：因为a[mid]<=k,所以a[mid]可能=k，所以mid坐标也满足条件，l = mid而不是mid+1;
                l = mid;
            } else {
                r = mid - 1; //这是a[mid] > k的时候。
            }
        }
        //标注4： 因为此时求得到的是最接近于目标值k的数，
        // 如果最小值都大于k的话，那么就没有办法得到了，所以就进行一个判断
        if (a[l] > k) return -1;
        //标注5： 其实这里无论返回 a[l] 还是a[r]都行，循环的退出时间是l == r 的时候
        return a[l];
    }
}
