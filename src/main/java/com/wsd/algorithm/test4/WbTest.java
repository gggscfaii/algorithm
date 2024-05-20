package com.wsd.algorithm.test4;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WbTest {
    private static final Pattern PATTERN = Pattern.compile("(.*)(\\d+)]");

    public static <T> T read(Object source, String fullPath) {
        if (source == null) {
            return null;
        }

        if (StringUtils.isEmpty(fullPath)) {
            return null;
        }

        int splitIndex = fullPath.indexOf("/");
        String path = fullPath;
        if (splitIndex > 0) {
            path = fullPath.substring(0, splitIndex);
        }

        T target = null;
        Matcher matcher = PATTERN.matcher(path);
        int groupIndex = -1;
        if (matcher.find()) {
            path = matcher.group(1).substring(0, matcher.group(1).indexOf('['));
            groupIndex = Integer.parseInt(matcher.group(2));
        }

        if (source instanceof Map) {
            target = (T) ((Map) source).get(path);
        }

        if (groupIndex > -1) {
            if (target instanceof List) {
                target = (T) ((List) target).get(groupIndex);
            } else {
                target = null;
            }
        }

        if (splitIndex > 0) {
            return read(target, fullPath.substring(splitIndex + 1));
        }
        return target;
    }

    public static void test_normal_find_value() {

        Map mapInList = new HashMap();
        mapInList.put("c", "Hi");

        Map mapA = new HashMap();
        mapA.put("def", Arrays.asList("a", "b", mapInList));

        Map source = new HashMap();
        source.put("a", mapA);

        String value = read(source, "a/def[1]");
        if (!"b".equals(value)) {
            System.out.println("test_normal_find_value error");
        }
    }

    public static void test_source_is_null() {

    }

    public static void test_path_is_null() {

    }

    public static void only_have_map() {
        Map source = new HashMap();
        source.put("a", "123");

        read(source,"a");
        read(source,"a/");
        read(source,"/a");
        read(source,"/a/");
    }

    public static void not_find_value() {

    }

    public static void only_have_list() {

        Map source = new HashMap();
        read(source,"[0]");
        read(source,"[-1]");
        read(source,"[0]/[1]");
    }


    public static void main(String[] args) {
        test_normal_find_value();
    }
}
