package com.wsd.algorithm.test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SignUtil {
    public static final String SIGN_FIELD = "sign";

    public static String createSignHmac(Map<String, Object> parameters, String secretKey) {
        String params = getAlphaSort(parameters);
        String sign = "";
        try {
            sign = hmacsha256(params, secretKey);
        } catch (Exception e) {
        }
        return sign;
    }

    public static String hmacsha256(String data, String key) throws Exception {
        Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        hmacSHA256.init(secretKey);

        byte[] array = hmacSHA256.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
        }
        return sb.toString();
    }

    /**
     * 参数进行字典序排列*
     *
     * @param params
     * @return
     */
    private static String getAlphaSort(Map<String, Object> params) {
        SortedMap<String, Object> sortedMap = new TreeMap<>(params);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            if (!SIGN_FIELD.contains(entry.getKey())) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}