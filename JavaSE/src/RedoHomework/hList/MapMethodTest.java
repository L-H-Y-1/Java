package RedoHomework.hList;

/*
    4. 现在有一个map集合如下：
    Map<Integer,String> map = new HashMap<Integer, String>();
    map.put(1, "张三丰");
    map.put(2, "周芷若");
    map.put(3, "汪峰");
    map.put(4, "灭绝师太");

    要求：
        1.遍历集合，并将序号与对应人名打印。
        2.向该map集合中插入一个编码为5姓名为郭靖的信息
        3.移除该map中的编号为1的信息
        4.将map集合中编号为2的姓名信息修改为"周林"
*/

/*
* map遍历
*   1   先获取key,遍历key
*           Set<Integer> keys = map.keySet();
            value 是 map.get(key)
*   2   entrySet
*           Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
            node.getKey()   node.getValue()
* */

/*
* map常用方法
*   1   new对象   Map<K,V> map = new HashMap<K,V>();
*   2   填加键值对     void map.put(K key,V value);
*   3   键值对个数   int map.size()
*   4   清空map   void map.clear()*
*
*   5   通过key获取value    V map.get(Object key)
*   6   通过key删除键值对  V map.remove(Object key)
*
*   7   是否包含key     boolean map.containsKey(Object key)
*   8   是否包含value   boolean map.comtainsValue(Object value)
*   9   是否为空    boolean map.isEmpty()
*
*   10  获取所有value   Collection<V> values = map.values()
*   11  获取所有key     Set<K> keys = map.keySet()
*
*   12  map-->Set   Set<Map.Entry<K,V>> entrySet = map.entrySet()
*   */

import java.util.*;

public class MapMethodTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");
        printData1(map);

        map.put(5,"郭靖");
        System.out.println("add郭靖:");
        printData2(map);

        System.out.println("key为5的value: "+map.get(5));

        System.out.println("是否包含key为4的键值对"+map.containsKey(4));
        System.out.println("是否包含value为John的键值对"+map.containsValue("John"));

        System.out.println("删除1");
        map.remove(1);
        printData1(map);

        System.out.println("键值对数量"+map.size());

        System.out.println("修改2为周林");
        map.put(2,"周林");
        printData2(map);

        System.out.println("======================");
        System.out.println("获取value的Collection");
        Collection<String> values = map.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("======================");

        System.out.println("清空map");
        map.clear();
        System.out.println("map是否为空"+map.isEmpty());
    }

    public static void printData1(Map map){
        //1
        System.out.println("-------------------");
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet  ) {
            System.out.println(key+"->"+map.get(key));
        }
        System.out.println("-------------------");
    }

    public static void printData2(Map map){
        //2 Set<Map.Entry<K,V>>  entrySet
        System.out.println("-------------------");
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        for ( Map.Entry<Integer,String> node : entrySet ) {
            System.out.println(node.getKey()+"-->"+node.getValue());
        }
        System.out.println("-------------------");
    }
}
