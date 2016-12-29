package shindo.Java.https;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @Title: HttpsDopost.java
 * @Description: HTTPSPOST方式提交数据
 * @author liuyaping
 * @date 2013-10-25 上午11:27:20
 * @version V1.0
 */
public class HttpsDopost {

    private static final String METHOD_POST = "POST";
    private static final String DEFAULT_CHARSET = "utf-8";
    private static final Logger doPostLogger = Logger.getLogger("doPost");

    public byte[] doPost(String url, byte[] params, String charset, int connectTimeout, int readTimeout) throws Exception {
        String ctype = "application/x-www-form-urlencoded; charset=" + charset;
        return doPost(url, ctype, params, connectTimeout, readTimeout);
    }

    private byte[] doPost(String url, String ctype, byte[] content, int connectTimeout, int readTimeout) throws Exception {
        HttpsURLConnection conn = null;
        OutputStream out = null;
        byte[] respByte;
        try {
            try {
                SSLContext ctx = SSLContext.getInstance("SSL");
                ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
                SSLContext.setDefault(ctx);

                conn = getConnection(new URL(url), METHOD_POST, ctype);
                conn.setHostnameVerifier(new HostnameVerifier() {
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });
                conn.setConnectTimeout(connectTimeout);
                conn.setReadTimeout(readTimeout);
            } catch (Exception e) {
                doPostLogger.error("GET_CONNECTOIN_ERROR, URL = " + url, e);
                throw e;
            }
            try {
                out = conn.getOutputStream();
                out.write(content);
                respByte = getResponseAsString(conn);
            } catch (IOException e) {
                doPostLogger.error("REQUEST_RESPONSE_ERROR, URL = " + url, e);
                throw e;
            }
        } finally {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return respByte;
    }

    private class DefaultTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    private HttpsURLConnection getConnection(URL url, String method, String ctype) throws IOException {
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
        conn.setRequestProperty("Encoding", ctype);
        conn.setRequestProperty("User-Agent", "stargate");
        conn.setRequestProperty("Content-Type", ctype);
        return conn;
    }

    protected byte[] getResponseAsString(HttpURLConnection conn) throws IOException {
        String charset = getResponseCharset(conn.getContentType());
        InputStream es = conn.getErrorStream();
        if (es == null) {
            return getStreamAsString(conn.getInputStream(), charset);
        } else {
            byte[] respByte = getStreamAsString(es, charset);
            if (respByte == null) {
                doPostLogger.info(new String(respByte, "utf-8"));
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                doPostLogger.info(new String(respByte, "utf-8"));
                return respByte;
            }
        }
    }

    private byte[] getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = stream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            return outStream.toByteArray();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private String getResponseCharset(String ctype) {
        String charset = DEFAULT_CHARSET;

        if (!StringUtils.isEmpty(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtils.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }
        return charset;
    }
}
