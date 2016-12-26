package shindo.Java;

public class TestSubString {
    public static void main(String[] args) {
        String cardNo = "6001075641737885";
        String a1 = cardNo.substring(0, 4);
        String a2 = cardNo.substring(4, 8);
        String a3 = cardNo.substring(8, 12);
        String a4 = cardNo.substring(12, 16);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);

        for (int i = 0; i <= 12; i += 4) {
            String result = cardNo.substring(i, i + 4);
            System.out.println("----------:" + result);
        }
    }
}
