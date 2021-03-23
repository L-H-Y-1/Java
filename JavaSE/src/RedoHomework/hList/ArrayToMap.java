package RedoHomework.hList;

/*
    5.有2个数组
        第一个数组内容为：[黑龙江省,浙江省,江西省,广东省,福建省]，
        第二个数组为：[哈尔滨,杭州,南昌,广州,福州]，

    将第一个数组元素作为key，第二个数组元素作为value存储到Map集合中。
    如{黑龙江省=哈尔滨, 浙江省=杭州, …}
*/


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArrayToMap {
    public static void main(String[] args) {
        String[] province = {"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] city = {"哈尔滨","杭州","南昌","广州","福州"};

        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < province.length; i++) {
            map.put(province[i],city[i]);
        }

        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for ( Map.Entry<String,String> node : entrySet ) {
            System.out.println(node.getKey()+"="+node.getValue());
        }
    }
}
