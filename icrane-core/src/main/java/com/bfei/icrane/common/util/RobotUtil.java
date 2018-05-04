package com.bfei.icrane.common.util;


import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by SUN on 2017/11/1.
 */
public class RobotUtil {

    public static final String APIURL = "http://www.tuling123.com/openapi/api";
    public static final String APIKEY = "79e70cd2738d41fe8bb26306ec5f2d82";

    public static String Robot(String keyword) throws Exception {
        String INFO = URLEncoder.encode(keyword, "utf-8");//这里可以输入问题
        String getURL = APIURL + "?key=" + APIKEY + "&info=" + INFO;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();

        // 取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        // 断开连接
        connection.disconnect();
        JSONObject jsonObject = JSONObject.fromObject(sb.toString());
        return jsonObject.get("text").toString();
    }

}
