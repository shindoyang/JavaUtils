package shindo.Java.corejava;

/**
 * Created by shindo.yang on 2017/8/16.
 */
public class VariableParameter {

    public static void main(String[] args) {
        System.out.println(2+5);
        System.out.println(3+8+1);
    }

    /**
     * 可变参数从jdk1.5之后支持，系统默认为可以参数创建数组，获取可变参数时，以解析数组的方式解析
     * 注意：可变参数只能放在参数列表的最后
     * @param x
     * @param args
     * @return
     */
    public static int add(int x , int ... args){
        int sum = x;
        for(int arg :args){
            sum += arg;
        }
        return sum;
    }

}
