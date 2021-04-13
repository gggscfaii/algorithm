package com.wsd.algorithm.basic;

public class 第十八题乒乓球比赛 {
    public static void main(String[] args) {
        /*
         * 思路：1 产生所有的可能
         *       2 去除不满足条件的
         */
        // char[] a = new char[]{'a', 'b', 'c'};
        // char[] b = new char[]{'x', 'y', 'z'};
        //
        // for (int i = 0; i < a.length; i++) {
        //     for (int j = 0; j < b.length; j++) {
        //         if (i == 0 && j == 0) { //排除a-x
        //             continue;
        //         } else if (i == 2 && j != 1) {
        //             continue;
        //         } else if (j == 1 && i != 2) { //排除c-x, c-z
        //             continue;
        //         } else {
        //             System.out.println("甲队：" + a[i] + " 乙队" + b[j]);
        //         }
        //     }
        // }

        char a,b,c;
        for(a = 'x'; a <= 'z'; a++) {
            for(b = 'x'; b <= 'z'; b++) {
                if(a != b) {   //避免参赛队员重复比赛
                    for(c = 'x'; c <= 'z'; c++) {
                        if(a != c && b != c) {	  //避免参赛队员重复比赛
                            if(a != 'x' && c != 'x' && c != 'z') {   //根据题意判断
                                System.out.printf("a和%s,b和%s，c和%s进行比赛",a,b,c);
                            }
                        }
                    }
                }
            }
        }
    }
}
