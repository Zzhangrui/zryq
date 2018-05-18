package com.zryq.cms.common.utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Richard on 14-11-27.
 */
@Component
public class HttpClientUtil {

    protected static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded;charset=utf-8";

    public static final String JSON_CONTENT_TYPE = "application/json;charset=utf-8";

    public static final int MAX_TOTAL = 1000;

    public static final int TIME_OUT = 1000;

    public static final int HTTP_TIME_OUT = 120000;

    /**
     * 短的http超时时间 7秒
     */
    public static final int HTTP_TIME_OUT_RESOURCE = 7000;

    public static final int REQUEST_TIME_OUT = 200;

    private static RestTemplate restTemplate;

    static {
        setConfig(HTTP_TIME_OUT);
    }

    private static void setConfig(int httpTimeOut) {
        // 长连接保持30秒
        PoolingHttpClientConnectionManager
                pollingConnectionManager = new PoolingHttpClientConnectionManager(TIME_OUT, TimeUnit.SECONDS);
        // 总连接数
        pollingConnectionManager.setMaxTotal(MAX_TOTAL);
        // 同路由的并发数
        pollingConnectionManager.setDefaultMaxPerRoute(MAX_TOTAL);

        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setConnectionManager(pollingConnectionManager);
        // 重试次数，默认是3次，没有开启
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
        // 保持长连接配置，需要在头添加Keep-Alive
        httpClientBuilder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());

        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36"));
        headers.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
        headers.add(new BasicHeader("Accept-Language", "zh-CN"));
        headers.add(new BasicHeader("Connection", "Keep-Alive"));

        httpClientBuilder.setDefaultHeaders(headers);
        HttpClient httpClient = httpClientBuilder.build();
        // httpClient连接配置，底层是配置RequestConfig
        HttpComponentsClientHttpRequestFactory
                clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        // 连接超时
        clientHttpRequestFactory.setConnectTimeout(httpTimeOut);
        // 数据读取超时时间，即SocketTimeout
        clientHttpRequestFactory.setReadTimeout(httpTimeOut);
        // 连接不够用的等待时间，不宜过长，必须设置，比如连接不够用时，时间过长将是灾难性的
        clientHttpRequestFactory.setConnectionRequestTimeout(REQUEST_TIME_OUT);
        // 缓冲请求数据，默认值是true。通过POST或者PUT大量发送数据时，建议将此属性更改为false，以免耗尽内存。
        // clientHttpRequestFactory.setBufferRequestBody(false);
        // 添加内容转换器
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        messageConverters.add(new ByteArrayHttpMessageConverter());

        restTemplate = new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
    }

    /**
     * 发送https get请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String doHttpsGet(String url) {
        try {
            enableSSL();
            return doHttpGet(url);
        } catch (Exception e) {
            logger.error("ssl error", e);
            return null;
        }
    }

    /**
     * 发送http请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String doHttpGet(String url, Object... urlVariables) {
        String result = restTemplate.getForObject(url, String.class, urlVariables);
        return result;
    }

    /**
     * 获取资源的二进制
     *
     * @param url
     * @return
     */
    public static byte[] doReourceHttpGet(String url) {
        setConfig(HTTP_TIME_OUT_RESOURCE);
        byte[] result = restTemplate.getForObject(url, byte[].class);
        return result;
    }

    /**
     * @param url
     * @param data
     * @return
     */
    public static String doHttpsPost(String url, String data) {
        try {
            enableSSL();
            return doHttpPost(url, data);
        } catch (Exception e) {
            logger.error("ssl error", e);
            return null;
        }
    }

    /**
     * http post请求
     *
     * @param url
     * @param data
     * @return
     */
    public static String doHttpPost(String url, String data) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(JSON_CONTENT_TYPE);
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<>(data, headers);
        String response = restTemplate.postForObject(url, formEntity, String.class);
        return response;
    }

    /**
     * http post请求s
     *
     * @param url
     * @param data
     * @param mediaType
     * @return
     */
    public static String doHttpPost(String url, String data, String mediaType) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType(mediaType);
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        String response = restTemplate.postForObject(url, formEntity, String.class);
        return response;
    }

    /**
     * 设置用户名头
     *
     * @param url
     * @return
     */
    public static String doHttpClientWithAuth(String url, String userName, String password) {
        HttpHeaders headers = createHeaders(userName, password);
        HttpEntity<String> formEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String>
                response = restTemplate.exchange(url, HttpMethod.GET, formEntity, String.class);
        return response.getBody();
    }

    public static String doHttpPostWithHeaders(String url, String data, HttpHeaders headers) {
        HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
        String response = restTemplate.postForObject(url, formEntity, String.class);
        return response;
    }

    /**
     * http post请求 用户名密码auth授权
     *
     * @param url
     * @param data
     * @return
     */
    public static String doHttpsPostWithAuth(String url, String data, String userName, String password) {
        HttpHeaders headers = createHeaders(userName, password);
        try {
            enableSSL();
            MediaType type = MediaType.parseMediaType(JSON_CONTENT_TYPE);
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
            return restTemplate.postForObject(url, formEntity, String.class);
        } catch (Exception e) {
            logger.error("ssl error ,", e);
        }
        return null;
    }

    public static HttpHeaders createHeaders(final String username, final String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);

                set("Authorization", authHeader);
            }
        };
    }

    /**
     * post方式http请求,所有参数已表单数据的形式提交，UTF-8编码
     *
     * @param urlPath 请求路径
     * @param params  请求消息体部分
     */
    public static String urlHttpPost(String urlPath, Map<String, Object> params) {
        // 组织请求参数
        try {
            StringBuilder postBody = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    postBody.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(), "utf-8")).append("&");
                }
            }
            if (!params.isEmpty()) {
                postBody.deleteCharAt(postBody.length() - 1);
            }

            enableSSL();

            URL urlTemp = new URL(urlPath);
            HttpsURLConnection conn = (HttpsURLConnection) urlTemp.openConnection();
            // 设置连接超时
            conn.setConnectTimeout(6000);
            // 设置读取超时
            conn.setReadTimeout(60000);
            // 提交参数
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBody.toString().getBytes());
            conn.getOutputStream().flush();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                logger.warn("invoke failed, response status:" + responseCode);
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return result.toString().trim();
        } catch (Exception e) {
            logger.error("", e);
        }
        return null;
    }

    private static void enableSSL() throws Exception {
        trustAllHttpsCertificates();
        initHostnameVerifier();
    }

    public static void initHostnameVerifier() {
        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String urlHostName, SSLSession session) {
                logger.warn("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

    public static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    static class miTM implements TrustManager, X509TrustManager {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            return;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            return;
        }
    }

    public static void main(String[] args) {
        String result = doHttpGet("http://www.douyu.com/directory/all");
        System.out.println("result = " + result);

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setUseInsecureSSL(true);
        try {
            HtmlPage htmlPage = webClient.getPage("http://www.douyu.com/directory/all");
            DomNodeList domNodeList = htmlPage.getElementsByTagName("a");


            //System.out.println("htmlPage = " + htmlPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
