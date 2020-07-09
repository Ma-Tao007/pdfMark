package com.example.family.utils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
@description
@anther  mt
@creater 2020-07-09 15:44
*/
public class Pdf {

    /**
     *  使用pdf.js存在跨域访问问题，这里将跨域pdf解决
     * @param request
     * @param response
     * @param file
     */
    public void resolutionPdfOrigin(HttpServletRequest request, HttpServletResponse response, String file){
        try{
            //主要代码    加入头部
            response.setContentType("application/pdf");
            response.setHeader("Access-Control-Allow-Origin", "*"); // 解决请求头跨域问题
            file = file.replace(" ", "");
            ServletOutputStream sos = response.getOutputStream();

            //读入流可能会出现中文路径找不到的问题   这里将文件中中文路径重新转码
            //mt
            //1.将文件路径分割成字符数组
            String[] str = file.split("/");
            for(int i = 0;i<str.length;i++){
                //使用正则找到中文
                Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
                Matcher m = p.matcher(str[i]);
                //将中文路径码后再去访问
                if (m.find()) {
                    file = file.replaceFirst(str[i], URLEncoder.encode(str[i],"UTF-8"));
                }
            }

            URL url = new URL(file);

            HttpURLConnection httpUrl = (HttpURLConnection)url.openConnection();
            // 连接指定的网络资源
            httpUrl.connect();
            // 获取网络输入流
            BufferedInputStream bis = new BufferedInputStream(httpUrl.getInputStream());
            int b;
            while ((b = bis.read())!= -1){
                sos.write(b);
            }
            sos.close();
            bis.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
