package com.wsd.algorithm.test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PhoneCleanTest {

    public static final String SK = "67d781c951ed4a881cc70170f536c7e0";
    private static final Random random = new Random();

    public static void main(String[] args) throws Exception {
        String url = uploadFile("C:\\data\\doc\\TrueCaller 爬虫系统部署.pdf");
        String dataKey = sendCleanPhone(url);
        String response = sendSearch(dataKey);
//        System.out.println(response);


//        sendSearch("phone_clear_increment_td_test_phone_clear_6");

    }

    public static String sendSearch(String dataKey) throws IOException {

        JSONObject request = new JSONObject();
        putRequestBasic(request);
        request.put("dataKey", dataKey);
        request.put("sign", SignUtil.createSignHmac(request, SK));

        Map<String, String> prop = new HashMap<>();
        prop.put("Content-Type", "application/json");
        String response = NetUtil.sendPost("http://localhost:8080/phone/clear/query/pay/result/v1", request.toString(), prop);
        System.out.println(response);
        return response;
    }

    public static String sendCleanPhone(String url) throws IOException {

        JSONObject request = new JSONObject();
        putRequestBasic(request);
        request.put("callBackUrl", "http://localhost:8084");
        request.put("companyName", "北京泰迪未来科技股份有限公司");
        request.put("licenseNumber", "91110108317961782R");

        JSONArray jsonArray = new JSONArray();
        JSONObject file = new JSONObject();
        file.put("name", "企业执照");
        file.put("url", url);
        jsonArray.add(file);

        JSONObject file1 = new JSONObject();
        file1.put("name", "企业执照");
        file1.put("url", url);
        jsonArray.add(file1);

        request.put("files", jsonArray);

        JSONArray phones = new JSONArray();
//        phones.add("045153807239");

        for (int i = 0; i < 1; i++) {
            phones.add(String.valueOf(18946276000111L + i));
        }
        request.put("phones", phones);
        request.put("sign", SignUtil.createSignHmac(request, SK));

        Map<String, String> prop = new HashMap<>();
        prop.put("Content-Type", "application/json");
        String response = NetUtil.sendPost("http://localhost:8080/phone/clear/pay/v1", request.toString(), prop);
        System.out.println(response);

        JSONObject jsonObject = JSONObject.parseObject(response);
        if (jsonObject.getIntValue("code") != 0) {
            throw new RuntimeException("上传文件失败");
        }
        return jsonObject.getJSONObject("data").getString("dataKey");
    }

    public static String uploadFile(String filePath) throws IOException {

        JSONObject request = new JSONObject();
        putRequestBasic(request);
        request.put("file", readFileToBase64(filePath));
        request.put("sign", SignUtil.createSignHmac(request, SK));

        Map<String, String> prop = new HashMap<>();
        prop.put("Content-Type", "application/json");
        String response = NetUtil.sendPost("http://localhost:8080/phone/clear/uploadcertfile/v1", request.toString(), prop);
        System.out.println(response);

        JSONObject jsonObject = JSONObject.parseObject(response);
        if (jsonObject.getIntValue("code") != 0) {
            throw new RuntimeException("上传文件失败");
        }
        return jsonObject.getJSONObject("data").getString("url");
    }

    private static void putRequestBasic(JSONObject request) {
        request.put("AccessKeyId", "td_test_phone_clear");
        request.put("nonce", 999 + random.nextInt(9000));
        request.put("timestamp", System.currentTimeMillis());
    }

    public static String readFileToBase64(String filePath) throws IOException {
        // 读取文件字节
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));

        // 转换为 Base64
        return Base64.getEncoder().encodeToString(fileBytes);
    }

}
