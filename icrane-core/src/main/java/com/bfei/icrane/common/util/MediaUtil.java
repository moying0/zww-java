package com.bfei.icrane.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SUN on 2017/11/1.
 */
public class MediaUtil {

    /**
     * 获取媒体文件
     *
     * @param accessToken 接口访问凭证
     * @param mediaId     媒体文件id
     * @param savePath    文件在服务器上的存储路径
     */
    public static String downloadMedia(String accessToken, String mediaId, String savePath) {
        String filePath = null;
        // 拼接请求地址
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            if (!savePath.endsWith("/")) {
                savePath += "/";
            }
            // 将mediaId作为文件名
            filePath = savePath + mediaId + ".AMR";
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            byte[] buf = new byte[8096];
            int size = 0;
            while ((size = bis.read(buf)) != -1){
                fos.write(buf, 0, size);
            }
            fos.close();
            bis.close();
            conn.disconnect();
        } catch (Exception e) {
            filePath = null;
        }
        return filePath;
    }
}
