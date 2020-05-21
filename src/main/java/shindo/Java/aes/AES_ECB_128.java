package shindo.Java.aes;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES_ECB_128 {

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    //    private static final String ALGORITHM = "AES/ECB/NoPadding";
//    private static final String CHARSET = "utf-8";
    private static final String CHARSET = "GBK";

    // 加密
    public static String Encrypt(byte[] sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes(CHARSET);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc);

        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 加密(返回byte[])
    public static byte[] EncryptByte(byte[] sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes(CHARSET);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM);//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc);

        return encrypted;//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes(CHARSET);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "UTF-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    /**
     * 创建指定数量的随机字符串
     *
     * @param numberFlag 是否是数字
     * @param length
     * @return
     */
    public static String generateAESKey(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);
        return retStr;
    }

    public static void main(String[] args) throws Exception {
        /*for(int k = 0;k<10; k++){
            System.out.println(getRandomNum(16));
        }*/

        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = generateAESKey(false, 16);
        // 需要加密的字串
        String cSrc = "优特智厨科技有限公司ABC-def123";//12345678901234567

        System.out.println("使用算法：" + AES_ECB_128.ALGORITHM);
        System.out.println("使用字符集：" + AES_ECB_128.CHARSET);
        System.out.println("待加密字符串长度:" + cSrc.length());

        // 加密
        String enString = AES_ECB_128.Encrypt(cSrc.getBytes(), cKey);
        System.out.println("AESECB128加密后的字串是：" + enString);

        // 解密
        String DeString = AES_ECB_128.Decrypt(enString, cKey);
        System.out.println("AESECB128解密后的字串是：" + DeString);
    }
}

