package shindo.Java.https;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {
    /**
     * http方式发送GET请求
     */
    public String sendGet(final String url) {
        String result = "";
        String respCode = "";
        BufferedReader in = null;
        try {
            final URL realUrl = new URL(url);
            // 打开和URL之间的连接
            final URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("conection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            final Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            // for(String key : map.keySet()){
            // System.out.println(key + "---->" + map.get(key));
            // }
            // 定义BufferReader输入流来读取URL响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            System.out.println("请求高汇通支付-退款响应结果：" + result);

            final String[] re = result.split("&");

            for (int i = 0; i < re.length; i++) {
                if (re[i].indexOf("respCode") >= 0) {
                    System.out.println(re[i]);
                    final String[] resp = re[i].split("=");
                    respCode = resp[1];
                    System.out.println("respCode = " + respCode);
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
            System.out.println("支付-退款请求出现异常！" + e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (final Exception e2) {
                e2.printStackTrace();
            }
        }
        return respCode;
    }
}
