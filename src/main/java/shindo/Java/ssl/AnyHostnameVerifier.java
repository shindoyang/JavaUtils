package shindo.Java.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @author ray.lei
 * @date 2017.04.11
 */
public class AnyHostnameVerifier implements HostnameVerifier {

	public AnyHostnameVerifier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean verify(String hostname, SSLSession session) {
		// TODO Auto-generated method stub
		return true;
	}

}
