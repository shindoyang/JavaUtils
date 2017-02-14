package shindo.Java.util;

public class Substring {
    public static void main(String[] args) {
        String[] cardArray = new String[] { "6001075619566282", "6001075879566282" };

        for (int i = 0; i < cardArray.length; i++) {
            StringBuffer bf = new StringBuffer();
            String cardNo = cardArray[i];
            for (int j = 0; j <= 12; j += 4) {
                String result = cardNo.substring(j, j + 4);
                bf.append(result).append(" ");
                System.out.println("----------:" + result);
            }
            System.out.println(bf.toString());
        }
    }
}
