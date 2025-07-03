package com.wsd.algorithm.basic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

public class GzipCompressor {
    public static byte[] compress(String data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data.getBytes());
        gzip.close();
        byte[] compressed = bos.toByteArray();
        bos.close();
        return compressed;
    }

    public static void main(String[] args) throws IOException {
        String json="{\n" +
                "\t\"header\": {\n" +
                "\t\t\"p2\": \"123445666\"\n" +
                "    },\n" +
                "\t\"data\": {\n" +
                "\t\t\"phone\": \"00918044207314\",\n" +
                "\t\t\"duration\": 10,\n" +
                "\t\t\"dataType\": 0,\n" +
                "\t\t\"operationType\": 1\n" +
                "\t}\n" +
                "}";
        byte[] compress = compress(json);
        System.out.println(Base64.getEncoder().encodeToString(compress));
    }
}