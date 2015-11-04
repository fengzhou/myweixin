package com.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2015/11/4.
 */
public class TulingUtils {


    private static final String  APIKEY = "40c59f61d2aaed81ee041af1c91c9044";

    public static void main(String[] args) {
        String result;
        try {
            result = tuling("成都");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String tuling(String msg)throws Exception{

        String INFO = URLEncoder.encode(msg,"utf-8");
        String getURl = "http://www.tuling123.com/openapi/api?key="+APIKEY+"&info="+INFO;
        URL getUrl = new URL(getURl);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();
        //取得输入流，病使用reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream()),"utf-8"));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = reader.readLine())!=null){
            sb.append(line);
        }
        reader.close();
        connection.disconnect();
        return sb.toString();
    }

}
