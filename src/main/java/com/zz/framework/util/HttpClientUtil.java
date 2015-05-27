package com.zz.framework.util;

import com.zz.framework.util.web.SimpleRequestRetryHandler;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex.Zhang on 2015/5/26.
 */
public class HttpClientUtil {

    //重复请求次数
    public static final int SIMPLE_RETY_COUNT = 3;



    /**
     * Get请求，返回字符串，默认请求重试3次。
     *
     * @param url
     * @param params
     * @return
     */
    public static final String doGet(String url, Map<String, String> params) {
        return doGet(url, params, SIMPLE_RETY_COUNT);
    }

    /**
     * Post请求，，返回字符串，默认重试3次
     *
     * @param url
     * @param params
     * @return
     */
    public static final String doPost(String url, Map<String, String> params) {
        return doPost(url, params, SIMPLE_RETY_COUNT);
    }


    public static final String doGet(String url, Map<String, String> params,
                                     int retryCount) {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setRetryHandler(new SimpleRequestRetryHandler(retryCount))
                .build();
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(setProtocol(url));
        if (params != null) {
            for (String key : params.keySet()) {
                if (params.get(key) != null) {
                    urlBuilder.append(key);
                    urlBuilder.append("=");
                    urlBuilder.append(params.get(key));
                }
            }
        }
        HttpGet getRequest = new HttpGet(urlBuilder.toString());
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(getRequest);
            int httpStatuCode = response.getStatusLine().getStatusCode();
            if (httpStatuCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    public static final String doPost(final String url, final Map<String, String> params, final int retryCount) {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setRetryHandler(new SimpleRequestRetryHandler(retryCount))
                .build();
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        if (params != null) {
            for (String key : params.keySet()) {
                if (params.get(key) != null) {
                    formParams.add(new BasicNameValuePair(key, params.get(key)));
                }
            }
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
        HttpPost postRequest = new HttpPost(setProtocol(url));
        postRequest.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(postRequest);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                return EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * htpp协议处理，如果url不以http://或https://开头，
     * <p>则默认使用http://
     * @param url
     * @return
     */
    public static final String setProtocol(String url) {
        if (!url.startsWith("http://") &&
                !url.startsWith("https://")) {
            url = url + "http://";
        }
        return url;
    }

    /**
     * 获取移动客户端传递参数
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getRequestBodyAsString(final HttpServletRequest request) throws IOException {
        String appMsg = "";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        // 一个个字符读取，2g手机网络一个TCP包较小
        while ((i = request.getInputStream().read()) != -1) {
            byteArrayOutputStream.write(i);
        }
        byte[] data = byteArrayOutputStream.toByteArray();
        appMsg=new String(data,"UTF-8");

        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();

        return appMsg;
    }
}
