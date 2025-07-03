package com.wsd.algorithm.test;


import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class NetUtil {
    public static String sendPost(String targetUrl, String paramStr, Map<String, String> prop) {
        System.out.println(paramStr);
        PrintWriter out = null;
        InputStream in = null;

        try {
            URL url = new URL(targetUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf8");

            if (prop != null && prop.size() > 0) {
                Iterator<String> it = prop.keySet().iterator();

                String key = null;
                String value = null;

                while (it.hasNext()) {
                    key = it.next();
                    value = prop.get(key);
                    conn.setRequestProperty(key, value);
                }
            }
            conn.connect();
            out = new PrintWriter(conn.getOutputStream());
            out.print(paramStr);
            out.flush();

            in = conn.getInputStream();
            String result = stream2Str(in);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static String sendPost(String targetUrl, JSONObject paramObj) {
        if (paramObj != null) {
            try {
                String paramStr = URLEncoder.encode(paramObj.toString(), "UTF-8");
                return sendPost(targetUrl, paramStr, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sendPost(targetUrl, null, null);
    }

    public static String sendPost(String targetUrl, Map<String, String> params) {
        return sendPost(targetUrl, params, null);
    }

    @SuppressWarnings("unchecked")
    public static String sendPost(String targetUrl, Object param, Map<String, String> prop) {
        if (param == null) {
            return sendPost(targetUrl, (String) null, prop);
        }

        String paramStr = null;

        if (param instanceof String) {
            paramStr = (String) param;
        } else if (param instanceof Map) {
            Map<String, String> paramMap = (Map<String, String>) param;
            if (paramMap.size() > 0) {
                try {
                    StringBuilder paramSb = new StringBuilder();
                    Iterator<String> it = paramMap.keySet().iterator();

                    String key = null;
                    String value = null;

                    while (it.hasNext()) {
                        key = it.next();
                        value = paramMap.get(key);

                        if (value != null) {
                            paramSb.append(key + "=" + URLEncoder.encode(value, "UTF-8"));
                            paramSb.append("&");
                        }
                    }

                    paramStr = paramSb.toString();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return sendPost(targetUrl, paramStr, prop);
    }

    @SuppressWarnings("unchecked")
    public static String constructTargetUrl(String targetUrl, Object param) {
        if (param == null) {
            return targetUrl;
        }

        if (param instanceof String) {
            String paramStr = (String) param;
            if (!"".equals(paramStr.trim())) {
                return targetUrl + (targetUrl.indexOf("?") > 0 ? "&" : "?") + param;
            } else {
                return targetUrl;
            }
        } else if (param instanceof Map) {
            Map<String, String> paramMap = (Map<String, String>) param;
            if (paramMap.size() > 0) {
                targetUrl += "?";
                Iterator<String> it = paramMap.keySet().iterator();
                while (it.hasNext()) {
                    String key = it.next();
                    String value = paramMap.get(key);

                    targetUrl += (key + "=" + value + "&");
                }

                targetUrl = targetUrl.substring(0, targetUrl.length() - 1);
            }

        }

        return targetUrl;
    }

    public static String sendGet(String targetUrl) {
        return sendGet(targetUrl, null, null);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.home"));
        System.setProperty("javax.net.ssl.trustStore", System.getProperty("java.home") + "/lib/security/jssecacerts");
        String url = "https://www.so.com/s?ie=utf-8&shb=1&src=home_so.com&q=15695284717";
        String result = sendGet(url, null, null);
        System.out.println(result);
    }

    public static String sendGet(String targetUrl, Object param, Map<String, String> prop) {
        try {
            targetUrl = constructTargetUrl(targetUrl, param);

            URL url = new URL(targetUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setUseCaches(false);

            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36");
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.setRequestProperty("Content-type", "text/html");
            conn.setRequestProperty("Connection", "close");

            if (prop != null && prop.size() > 0) {
                Iterator<String> it = prop.keySet().iterator();

                String key = null;
                String value = null;

                while (it.hasNext()) {
                    key = it.next();
                    value = prop.get(key);
                    conn.setRequestProperty(key, value);
                }
            }

            if (conn.getResponseCode() == 200) {
                String result = stream2Str(conn.getInputStream());
                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected static String stream2Str(InputStream inputstream) {
        StringBuffer stringbuffer = new StringBuffer();

        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputstream, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            inputStreamReader = new InputStreamReader(inputstream);
        }

        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                if (stringbuffer.length() == 0) {
                    stringbuffer.append(line);
                } else {
                    stringbuffer.append("\n").append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringbuffer.toString();
    }
}
