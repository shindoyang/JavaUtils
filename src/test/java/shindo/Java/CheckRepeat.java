package shindo.Java;

import java.util.ArrayList;
import java.util.List;

public class CheckRepeat {

    /*public static void main(String[] args) {
        int[] arry = { 1, 10, 5, 8, 11, 100, 99, 10 };
    
        // 用于判断是否有重复值的标记
        boolean flag = false;
        for (int i = 0; i < arry.length; i++) {
            int temp = arry[i];
            int count = 0;
            for (int j = 0; j < arry.length; j++) {
                int temp2 = arry[j];
                // 有重复值就count+1
                if (temp == temp2) {
                    count++;
                }
            }
            // 由于中间又一次会跟自己本身比较所有这里要判断count>=2
            if (count >= 2) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("有重复值存在！！！");
        } else {
            System.out.println("没有重复值存在！！！");
        }
    }*/

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(10);
        list.add(5);
        list.add(8);
        list.add(11);
        list.add(100);
        list.add(99);
        list.add(10);

        // 用于判断是否有重复值的标记
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            int temp = (Integer) list.get(i);

            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                int temp2 = (Integer) list.get(j);
                // 有重复值就count+1
                if (temp == temp2) {
                    count++;
                }
            }
            // 由于中间又一次会跟自己本身比较所有这里要判断count>=2
            if (count >= 2) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("有重复值存在！！！");
        } else {
            System.out.println("没有重复值存在！！！");
        }
    }
}
