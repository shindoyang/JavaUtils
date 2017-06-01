package shindo.Java.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapToSort {
    public static void main(String[] args) {
        // SortedMap会自动排序
        SortedMap<String, String> map = new TreeMap<String, String>();
        map.put("merID", "123");// 商户号
        map.put("orderNum", "0001");
        map.put("returnAmount", "25");
        map.put("transID", "");
        map.put("signType", "sha256");
        map.put("paymentSchema", "PF");

        Set es = map.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            System.out.println(k + "=" + v + ";\n");
        }

    }
}
