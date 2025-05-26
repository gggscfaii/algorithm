package com.wsd.algorithm.interview;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class XF {
    public static void main(String[] args) {

        String filePath = "C:\\data\\book\\AE20221100000_59064374.pdf";
        try {
            // 读取文件字节
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));

            // 转换为 Base64
            String base64Content = Base64.getEncoder().encodeToString(fileBytes);

            // 输出结果
            System.out.println(base64Content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFileToBase64(String filePath) throws IOException {
        // 读取文件字节
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));

        // 转换为 Base64
        return Base64.getEncoder().encodeToString(fileBytes);
    }
}
