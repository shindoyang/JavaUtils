package shindo.Java.ssl;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * HttpPost工具类
 * @author ray.lei
 * @date 2017.04.11
 */
public class HttpKit {

	private static final String DEFAULT_CHARSET = "utf-8";
	private static final Logger doPostLogger = Logger.getLogger("doPost");
	/**
	 * 发送HTTPS请求
	 * @param url 请求地址
	 * @param data 请求数据
	 * @return 返回字符串
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	private static String httpsClient(String url,String data) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException{
		//创建SSLContext对象，并使用我们指定的信任管理器初始化(信任任何证书)
		TrustManager[] tm = {new https.X509TrustAnyManager()};
		SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());


		//创建URL对象
		URL reqURL = new URL(url);
		//创建HttpsURLConnection对象
		HttpsURLConnection httpsConn = (HttpsURLConnection)reqURL.openConnection();
		//信任任何证书域名
		httpsConn.setHostnameVerifier(new AnyHostnameVerifier());

		//从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();

		//设置其SSLSocketFactory对象
		httpsConn.setSSLSocketFactory(ssf);
		//httpsConn.connect();

		/*下面这段代码实现向Web页面发送数据，实现与网页的交互访问*/
		httpsConn.setDoOutput(true);
		httpsConn.setRequestProperty("User-Agent", "Mozilla/5.0");
		//httpsConn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		//httpsConn.setRequestProperty("Accept-Encoding","gzip, deflate, sdch, br");
		//httpsConn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
		httpsConn.setConnectTimeout(60*1000);//连接超时(毫秒)

		if(data!=null){
			OutputStreamWriter wr = new OutputStreamWriter(httpsConn.getOutputStream());//, "utf-8"
			try{
				wr.write(data);
				wr.flush();
			}
			catch(IOException e){
				throw e;
			}
			finally{
				if(wr!=null)wr.close();
			}
		}

		//取得该连接的输入流，以读取响应内容
		InputStream input=httpsConn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		StringBuilder out=new StringBuilder();
		try{
			//读取服务器的响应内容并显示
			String line = "";
			while( (line=br.readLine()) != null){
				//System.out.println(line);
				out.append(line);
			}
		}
		catch(IOException e){
			throw e;
		}
		finally{
			br.close();
			if(input!=null)input.close();
		}
		return out.toString();
	}

	/**
	 * 发送HTTPS请求
	 * @param url 请求地址
	 * @param data 请求数据
	 * @return 返回字符串
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	public byte[] httpsDoPost(String url,String data) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException{
		byte[] respByte = new byte[0];

		//创建SSLContext对象，并使用我们指定的信任管理器初始化(信任任何证书)
		TrustManager[] tm = {new X509TrustAnyManager ()};
		SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());


		//创建URL对象
		URL reqURL = new URL(url);
		//创建HttpsURLConnection对象
		HttpsURLConnection httpsConn = (HttpsURLConnection)reqURL.openConnection();
		//信任任何证书域名
		httpsConn.setHostnameVerifier(new AnyHostnameVerifier());

		//从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();

		//设置其SSLSocketFactory对象
		httpsConn.setSSLSocketFactory(ssf);
		//httpsConn.connect();

		/*下面这段代码实现向Web页面发送数据，实现与网页的交互访问*/
		httpsConn.setDoOutput(true);
		httpsConn.setRequestProperty("User-Agent", "Mozilla/5.0");
		//httpsConn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		//httpsConn.setRequestProperty("Accept-Encoding","gzip, deflate, sdch, br");
		//httpsConn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
		httpsConn.setConnectTimeout(60*1000);//连接超时(毫秒)

		if(data!=null){
			OutputStream out = httpsConn.getOutputStream();//, "utf-8"
			try{
				out.write(data.getBytes());
				respByte = getResponseAsString(httpsConn);
				out.flush();
			}
			catch(IOException e){
				throw e;
			}
			finally{
				if(out!=null)out.close();
			}
		}

		return respByte;
	}

	protected byte[] getResponseAsString(HttpURLConnection conn) throws IOException {
		String charset = getResponseCharset(conn.getContentType());
		InputStream es = conn.getErrorStream();
		if(es == null) {
			return getStreamAsString(conn.getInputStream(), charset);
		}else{
			byte[] respByte = getStreamAsString(es, charset);
			if(respByte==null) {
				doPostLogger.info(new String(respByte,"utf-8"));
				throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
			}else {
				doPostLogger.info(new String(respByte,"utf-8"));
				return respByte;
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

	private byte[] getStreamAsString(InputStream stream, String charset) throws IOException {
		try {
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			int len = 0;
			byte[] buffer = new byte[1024];
			while((len=stream.read(buffer))!=-1){
				outStream.write(buffer, 0, len);
			}
			return outStream.toByteArray();
		} finally {
			if (stream != null) {
				stream.close();
			}
		}
	}

	/**
	 * 发送HTTPS请求(带微信证书)
	 * @param url 请求地址
	 * @param data 请求数据
	 * @param mch_id 商户ID
	 * @return 返回字符串
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	public static String httpsClientWithWechatCA(String url,String data, String mch_id) throws Exception{

		KeyStore keyStore  = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File("D:/WechatCA/apiclient_cert.p12"));
		try {
			keyStore.load(instream, mch_id.toCharArray());
		} finally {
			instream.close();
		}

		// Trust own CA and all self-signed certs
		SSLContext sslcontext = SSLContexts.custom()
				.loadKeyMaterial(keyStore, mch_id.toCharArray())
				.build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext,
				new String[] { "TLSv1" },
				null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf)
				.build();

		try {
			HttpPost httpPost=new HttpPost(url);
			StringEntity stringEntity = new StringEntity(data, "UTF-8");
			//stringEntity.setContentType("application/x-www-form-urlencoded");
			//stringEntity.setContentType("text/xml");
			httpPost.addHeader("Content-Type", "text/xml");	//是否要加这一句，要看测试情况
			httpPost.setEntity(stringEntity);

			//HttpGet httpget = new HttpGet("https://api.mch.weixin.qq.com/secapi/pay/refund");
			doPostLogger.debug("executing request" + httpPost.getRequestLine());

			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();

				doPostLogger.debug("--------------------response.getStatusLine()--------------------");
				doPostLogger.debug(response.getStatusLine());
				if (entity != null)
					try{
						doPostLogger.debug("Response content length: " + entity.getContentLength());
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
						String text;
						StringBuilder out=new StringBuilder();
						while ((text = bufferedReader.readLine()) != null) {
							//logger.debug(text);
							out.append(text);
						}
						return out.toString();
					}finally{
						EntityUtils.consume(entity);
					}
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
		return null;
	}

	/**
	 * 发送HTTP请求
	 * @param url 请求地址
	 * @param data 请求数据
	 * @return 返回字符串
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	private static String httpClient(String url,String data) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException{
		//创建URL对象
		URL reqURL = new URL(url);
		//创建HttpsURLConnection对象
		URLConnection httpsConn = reqURL.openConnection();

		
		/*下面这段代码实现向Web页面发送数据，实现与网页的交互访问*/
		httpsConn.setDoOutput(true);
		httpsConn.setRequestProperty("User-Agent", "Mozilla/5.0");
		//httpsConn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		//httpsConn.setRequestProperty("Accept-Encoding","gzip, deflate, sdch, br");
		//httpsConn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
		httpsConn.setConnectTimeout(60*1000);//连接超时(毫秒)

		if(data!=null){
			OutputStreamWriter wr = new OutputStreamWriter(httpsConn.getOutputStream());//, "utf-8"
			try{
				wr.write(data);
				wr.flush();
			}
			catch(IOException e){
				throw e;
			}
			finally{
				if(wr!=null)wr.close();
			}
		}

		//取得该连接的输入流，以读取响应内容 
		InputStream input=httpsConn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		StringBuilder out=new StringBuilder();
		try{
			//读取服务器的响应内容并显示
			String line = "";
			while( (line=br.readLine()) != null){
				//System.out.println(line);
				out.append(line);
			}
		}
		catch(IOException e){
			throw e;
		}
		finally{
			br.close();
			if(input!=null)input.close();
		}
		return out.toString();
	}

	/**
	 * http post提交数据(支持SSL)
	 * @param url 请求地址
	 * @param data 请求数据
	 * @return 返回字符串
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws IOException
	 */
	public static String post(String url,String data) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException{
		if(url==null || url.length()<5){
			return null;
		}
		if(url.substring(0, 5).toLowerCase().equals("https")){
			return httpsClient(url,data);
		}else{
			return httpClient(url,data);
		}
	}

	public static void main( String[] args ) throws Exception
	{
		//String out=httpClient("http://localhost/pay/oauth2/code.html","code=123&state=STATE");
		//System.out.println(out);

		String url="https://api.mch.weixin.qq.com/secapi/pay/refund";
		String data=new StringBuilder().append("<xml>").
				append("<appid>wx2421b1c4370ec43b</appid>").
				append("<mch_id>10000100</mch_id>").
				append("<nonce_str>6cefdb308e1e2e8aabd48cf79e546a02</nonce_str>").
				append("<op_user_id>10000100</op_user_id>").
				append("<out_refund_no>1415701182</out_refund_no>").
				append("<out_trade_no>1415757673</out_trade_no>").
				append("<refund_fee>1</refund_fee>").
				append("<total_fee>1</total_fee>").
				append("<transaction_id></transaction_id>").
				append("<sign>FE56DD4AA85C0EECA82C35595A69E153</sign>").
				append("</xml>").toString();
		String mch_id="4462200";

		String out=httpsClientWithWechatCA(url,data,mch_id);
		System.out.println(out);
	}
}
