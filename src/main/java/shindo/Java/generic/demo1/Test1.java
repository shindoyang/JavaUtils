package shindo.Java.generic.demo1;

public class Test1 {
    public static void main(String[] args) {
        Point<String> p = new Point<String>();// 里面的var类型为String类型
        p.setVar("shindo");// 设置字符串
        System.out.println(p.getVar().length());// 取得字符串的长度
    }
}
