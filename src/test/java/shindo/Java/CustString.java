package shindo.Java;

import java.io.UnsupportedEncodingException;

public class CustString {
	public static void main(String[] args) 
			throws UnsupportedEncodingException {
			  String s = 
			"【包邮装】Viscontour 维诗朵 玻尿酸精华液 30支（强效去皱抗衰老） 013;【好喝又便宜】双支装平价却倍感惊艳的德国进口雷司令半甜白 的圣母之爱 020;ROHTO OXY 酷爽清凉UV防晒喷雾 015;ROHTO 肌研白润药用美白面膜 20ml*4枚 015;高丝 玻尿酸保湿美容液面膜 26枚 015;高丝美白面膜 26回 015;澳洲Dermatix 疤痕膏15g 014";
			  // 获取GBK编码下的字节数据
			  byte[] data = s.getBytes("GBK");
			  byte[] tmp = new byte[200];
			  // //将data数组的前六个字节拷贝到tmp数组中
			  System.arraycopy(data, 0, tmp, 0, 200); 
			//
			  // 将截取到的前六个字节以字符串形式输出到控制台
			  s = new 
			 String(tmp,"GBK");
			  System.out.println(s);
			 }
			
}
