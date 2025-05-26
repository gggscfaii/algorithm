package com.wsd.algorithm.interview;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
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
        for (byte item: array) {
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

    public static void main(String[] args) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get("c:\\data\\long.txt")),
                StandardCharsets.UTF_8);

        content="{\n" +
                "    \"user\":\"td_test\",\n" +
                "    \"sign\":\"df047a32183e7320828a590055d1634a\",\n" +
                "    \"nonce\":\"123\",\n" +
                "    \"timestamp\":1747997460000,\n" +
                "    \"dataKey\": \"phone_clear_increment_td_test_15\"\n" +
                "}";


//        content="{\n" +
//                "    \"user\":\"td_test\",\n" +
//                "    \"sign\":\"047866976d0c046f6bcd8821565645e85b416d5243690be643b3d116fceef61c\",\n" +
//                "    \"nonce\":\"123\",\n" +
//                "    \"timestamp\":1747997460000,\n" +
//                "    \"phone\":188888\n" +
//                "}";
        HashMap map = JSONObject.parseObject(content, HashMap.class);
        System.out.println(createSignHmac(map, "s8blxpcjiutur2ipp6tp0q94sdf9svql"));
    }
}