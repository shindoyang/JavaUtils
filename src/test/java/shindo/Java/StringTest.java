package shindo.Java;

import java.io.UnsupportedEncodingException;

public class StringTest {
    public static void main(String[] args) throws Exception {
        /*String str = "D168//1QrCkfu6m4+4BEKUG3p4QXumm4nTGlwJX09bMZR7U1u63MC1FkOq4BZQkbdwsVTnOpX8LC/9kkvNioCfPfpD+omMdYY0kWdVzHRozpWPkqpD/e04hes78GZGlyeUiOfxgIfVNkERbb2Opaf17+7OUjq0U9EXoCsxqrSNxkyYoBaj5L7lC+y7frFoj9hYLAeICyyBXcQboE804rZdMiLkeJhNk4g+PLZbDLhtZJW0LagM8JV/zq2QGYB+xHKMAKpJ7uoty1bmcXmbgQMPxyEF51xUbBeckJCvP7JVhkVN9Ig9o5flSgRIK9UVcGbcOmr9mLwnAuiiIrnjfSlA==";
        System.out.println(str.length());*/

        /*String url = "https://www.test.com";
        System.out.println(url);
        url = url.substring(5);
        url = "http" + url;
        System.out.println(url); */

        /*String md5key = "10561eb87e534930b9d8b37ed46d778a";
        System.out.println(md5key.length());*/

        /*String pimg = "https://www.123.com";
        if (pimg.contains("https")) {
            pimg = "http" + pimg.substring(5);
            System.out.println(pimg);
        }*/

        String v = "【包邮装】Viscontour 维诗朵 玻尿酸精华液 30支（强效去皱抗衰老） 013;【好喝又便宜】双支装平价却倍感惊艳的德国进口雷司令半甜白 的圣母之爱 020;ROHTO OXY 酷爽清凉UV防晒喷雾 015;ROHTO 肌研白润药用美白面膜 20ml*4枚 015;高丝 玻尿酸保湿美容液面膜 26枚 015;高丝美白面膜 26回 015;澳洲Dermatix 疤痕膏15g 014;台湾JOJO儿童水果钙片105克 001";
        System.out.println(v.getBytes("GBK").length);
        byte[] vb = v.getBytes("GBK");
        byte[] bb = new byte[200];
        if(vb.length>200){
        	System.arraycopy(vb, 0, bb, 0, 200);
        	/*src：byte源数组
        	srcPos：截取源byte数组起始位置（0位置有效）
        	dest,：byte目的数组（截取后存放的数组）
        	destPos：截取后存放的数组起始位置（0位置有效）
        	length：截取的数据长度*/
        }
        String result = new String(bb,"GBK");
        System.out.println(result.getBytes("GBK").length);
        System.out.println(result);
        
        

    }
}
