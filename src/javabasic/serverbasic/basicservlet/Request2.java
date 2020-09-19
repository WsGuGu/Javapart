package javabasic.serverbasic.basicservlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * @email:wildgugu@qq.com
 * @Date:2020/7/13--10:33
 *封装请求协议:封装请求参数为map
 */
public class Request2 {
    //协议信息
    private String requestInfo;
    //请求方式
    private String method;
    //请求url
    private String url;
    //请求参数
    private String queryStr;
    //存储参数
    private Map<String, List<String>> parameterMap;
    private final String CRLF = "\r\n";

    public Request2(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request2(InputStream is) {
        parameterMap = new HashMap<>();
        byte[] datas = new byte[1024 * 1024];
        int len = 0;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas, 0, len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
    }

    private void parseRequestInfo() {
        System.out.println("------分解-------");
        System.out.println("----1.获取请求方式----");
        this.method = this.requestInfo.substring(0, this.requestInfo.indexOf("/")).toLowerCase();
        this.method = this.method.trim();
        System.out.println("----2.获取请求的url----");
        int startldx = this.requestInfo.indexOf("/");
        int endldx = this.requestInfo.indexOf("HTTP/");
        this.url = this.requestInfo.substring(startldx, endldx);
        int queryldx = this.url.indexOf("?");
        if (queryldx >= 0) {
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0];
            this.queryStr = urlArray[1];
        }
        System.out.println(this.url);
        if (method.equals("post")) {
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if (queryStr == null) {
                queryStr = qStr;
            } else {
                queryStr += "&" + qStr;
            }
        }
        queryStr = queryStr == null ? "" : queryStr;
        System.out.println(method + "---->" + url + "--->" + queryStr);
        //转成Map
        convertMap();
    }

    //处理请求参数为map
    private void convertMap() {
        //分割字符串
        String[] keyValues = this.queryStr.split("&");
        for (String query : keyValues) {
            //再次分割字符串
            String[] kv = query.split("=");
            kv = Arrays.copyOf(kv, 2);
            //获取key和value
            String key = kv[0];
            String value = kv[1]==null?null:decode(kv[1],"UTF-8");
            //存储到map
            if (!parameterMap.containsKey(key)) {
                parameterMap.put(key, new ArrayList<>());
            }
            parameterMap.get(key).add(value);
        }
    }
    private String decode(String value,String enc){
        try {
            return java.net.URLDecoder.decode(value,enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String[] getParameterValues(String key) {
        List<String> values = this.parameterMap.get(key);
        if (values==null||values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }
    public String getParameter(String key) {
      String[] values=getParameterValues(key);
      return values==null?null:values[0];
    }
    public String getMethod() {
        return method;
    }
    public String getUrl() {
        return url;
    }
    public String getQueryStr() {
        return queryStr;
    }
}