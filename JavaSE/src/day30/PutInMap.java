/*
5.有2个数组，第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，
第二个数组为：[哈尔滨,杭州,南昌,广州,福州]，
将第一个数组元素作为key，第二个数组元素作为value存储到Map集合中。
如{黑龙江省=哈尔滨, 浙江省=杭州, …}
*/

package day30;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PutInMap {
    public static void main(String[] args) {
        String[] provinces = {"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] cities = {"哈尔滨","杭州","南昌","广州","福州"};

        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < provinces.length; i++) {
            map.put(provinces[i],cities[i]);
        }

        Set<Map.Entry<String,String>> set = map.entrySet();
        System.out.println("-----------------------------------------");
        for ( Map.Entry<String,String> node : set  ) {
            System.out.println(node.getKey() + "=" + node.getValue());
        }
        System.out.println("-----------------------------------------");
    }
}

/*
* result
        -----------------------------------------
        福建省=福州
        浙江省=杭州
        江西省=南昌
        广东省=广州
        黑龙江省=哈尔滨
        -----------------------------------------
* */
