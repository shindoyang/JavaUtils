package shindo.Java.util;

public class MsEncryptDecrypt {
    public static void main(String[] args) {
        String cardNo = "6001075659340259";
        String en_cardNo = encrypt(cardNo);
        System.out.println(en_cardNo);

        // 解密
        String de_cardNo = decrypt(en_cardNo);
        System.out.println(de_cardNo);

        System.out.println(cardNo.equals(de_cardNo));
    }

    /**
     * 加密
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param data
     * @return
     * @author Shindo   
     * @date 2016年12月27日 上午11:29:12
     */
    public static String encrypt(String data) {
        StringBuffer re = new StringBuffer();
        for (int i = 0; i < data.length(); i++) {
            String b = data.substring(i, i + 1);
            b = en_replace(b);
            re.append(b);
        }

        return re.toString();
    }

    /**
     * 解密
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param data
     * @return
     * @author Shindo   
     * @date 2016年12月27日 上午11:29:19
     */
    public static String decrypt(String data) {
        StringBuffer re = new StringBuffer();
        for (int i = 0; i < data.length(); i++) {
            String b = data.substring(i, i + 1);
            b = de_replace(b);
            re.append(b);
        }

        return re.toString();
    }

    public static String en_replace(String str) {
        if ("0".equals(str)) {
            str = "A";
        } else if ("1".equals(str)) {
            str = "B";
        } else if ("2".equals(str)) {
            str = "C";
        } else if ("3".equals(str)) {
            str = "D";
        } else if ("4".equals(str)) {
            str = "E";
        } else if ("5".equals(str)) {
            str = "F";
        } else if ("6".equals(str)) {
            str = "G";
        } else if ("7".equals(str)) {
            str = "H";
        } else if ("8".equals(str)) {
            str = "I";
        } else if ("9".equals(str)) {
            str = "J";
        }
        return str;
    }

    public static String de_replace(String str) {
        if ("A".equals(str)) {
            str = "0";
        } else if ("B".equals(str)) {
            str = "1";
        } else if ("C".equals(str)) {
            str = "2";
        } else if ("D".equals(str)) {
            str = "3";
        } else if ("E".equals(str)) {
            str = "4";
        } else if ("F".equals(str)) {
            str = "5";
        } else if ("G".equals(str)) {
            str = "6";
        } else if ("H".equals(str)) {
            str = "7";
        } else if ("I".equals(str)) {
            str = "8";
        } else if ("J".equals(str)) {
            str = "9";
        }
        return str;
    }
}
