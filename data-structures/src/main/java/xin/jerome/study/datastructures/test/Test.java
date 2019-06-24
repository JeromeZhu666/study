package xin.jerome.study.datastructures.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Jerome Zhu
 * @since 2019.06.02 15:50
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("key"+i, i);
        }
        /*Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey()+"-----"+e.getValue());
        }*/

        /*Set<String> keys = map.keySet();
        for (String s : keys) {
            System.out.println(String.format("%s------%d",s, map.get(s)));
        }*/

        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key + "---" + map.get(key));
        }
    }
}
