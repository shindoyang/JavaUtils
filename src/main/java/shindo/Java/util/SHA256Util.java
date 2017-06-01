package shindo.Java.util;

import java.security.MessageDigest;

public class SHA256Util {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static void main(String[] arg) {

        System.out.println(SHA256Util.SHA256Encode(
                "amount=0.01&bank_code=ALIPAY&busi_code=SEARCH&currency_type=CNY&mer_abbr=广州市花都区花山江滨通讯店&mer_id=986000000000004&merchant_no=102100000125&order_no=SO1490832352099&pay_no=36248&pay_result=1&pay_time=20170414145608&resp_code=00&resp_desc=Success&sett_date=20170414&sett_time=145608&sign_type=SHA256&terminal_no=20000147&user_bank_card_no=2088002753442344|727***@qq.com&key=857e6g8y51b5k365f7v954s50u24h14w",
                "utf-8"));
    }

    public static String SHA256Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

}
