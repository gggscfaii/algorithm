package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/13.
 */
public class A71_SimplifyPath {

    public static String simplifyPath(String path) {
        List<String> paths = new ArrayList<>();
        int i = 0, len = path.length();
        while (i < len) {
            StringBuilder sb = new StringBuilder();
            char c;
            while (i < len && (c = path.charAt(i++)) != '/') {
                sb.append(c);
            }

            String subPath = sb.toString();
            if ("".equals(subPath) || subPath.equals(".")) {

                continue;
            }

            if (subPath.equals("..")) {
                if (paths.size() > 0)
                    paths.remove(paths.size() - 1);
            } else {
                paths.add(subPath);
            }
        }

        if (paths.size() <= 0) return "/";

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < paths.size(); j++) {
            sb.append("/").append(paths.get(j));
        }
        return sb.toString();
    }


    public static String simplifyPath1(String path) {

        String result = "";
        String[] elems = path.split("/");

        int ignor = 0;
        for (int i = elems.length - 1; i >= 0; i--) {

            if (elems[i].equals("") || elems[i].equals(".")) {
                continue;
            }
            if (elems[i].equals("..")) {
                ignor++;
                continue;
            }
            if (ignor > 0) {
                ignor--;
                continue;
            }
            if (result.length() == 0) {
                result = "/" + elems[i];
            } else {
                result = "/" + elems[i] + result;
            }
        }

        return result.length() != 0 ? result : "/";

    }


    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));

        System.out.println(simplifyPath1("/home/"));
        System.out.println(simplifyPath1("/../"));
        System.out.println(simplifyPath1("/home//foo/"));
        System.out.println(simplifyPath1("/a/./b/../../c/"));
        System.out.println(simplifyPath1("/a/../../b/../c//.//"));
        System.out.println(simplifyPath1("/a//b////c/d//././/.."));

    }

}
