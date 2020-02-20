package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/20.
 */
public class A93_RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s, 0);
    }

    public static List<String> restoreIpAddresses(String s, int start) {

        List<String> ips = new ArrayList<>();
        int begin = 1, end = s.length();
        if (start == 3) {
            begin = s.length();
        }

        for (int i = begin; i <= end; i++) {
            String ip = s.substring(0, i);
            if (ip.isEmpty() || ip.length() > 3) {
                continue;
            }

            int val = Integer.parseInt(ip);
            if (!Integer.toString(val).equals(ip) || val > 255) {
                continue;
            }

            if (start == 3) {
                ips.add(ip);
                return ips;
            }

            List<String> subIps = restoreIpAddresses(s.substring(i), start + 1);
            for (String subIp : subIps) {
                ips.add(ip + "." + subIp);
            }
        }
        return ips;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("1111"));

    }

}
