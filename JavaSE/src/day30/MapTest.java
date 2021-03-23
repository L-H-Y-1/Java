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
* 思路
* 1 遍历方法    将key转成set
*                   Set<Integer> keys = map.keySet();
*                   value为 map.get(key)
*              将map转成set
*                   Set<Map.Entry<Integer,String>> set = map.entrySet();
*                   key为 node.getKey()
*                   value为 node.getValue()
* 2 修改信息    map中存入已有key时,新value会覆盖旧value
* */

package day30;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>() ;
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");

        //遍历map方法1,将key转换成set
        System.out.println("--------------------------------");
        System.out.println("遍历map方法1,将key转换成set");
        Set<Integer> keys = map.keySet();
        for (Integer key : keys  ) {
            System.out.println(key + " " + map.get(key));
        }

        //遍历map方法2,将map集合转换成set
        System.out.println("--------------------------------");
        System.out.println("遍历map方法2,将map集合转换成set");
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for (Map.Entry<Integer,String> node : set  ) {
            System.out.println(node.getKey() + " " + node.getValue());
        }

        //插入信息
        map.put(5,"郭靖");
        System.out.println("--------------------------------");
        System.out.println("插入编码为5姓名为郭靖的信息(方法1)");
        Set<Integer> keys2 = map.keySet();
        for (Integer key : keys2  ) {
            System.out.println(key + " " + map.get(key));
        }

        //移除该map中的编号为1的信息
        map.remove(1);
        System.out.println("--------------------------------");
        System.out.println("移除该map中的编号为1的信息(方法2)");
        Set<Map.Entry<Integer,String>> set2 = map.entrySet();
        for (Map.Entry<Integer,String> node : set2  ) {
            System.out.println(node.getKey() + " " + node.getValue());
        }

        //将map集合中编号为2的姓名信息修改为"周林"
        map.put(2,"周林");
        System.out.println("--------------------------------");
        System.out.println("将map集合中编号为2的姓名信息修改为周林(方法1)");
        Set<Integer> keys3 = map.keySet();
        for (Integer key : keys3  ) {
            System.out.println(key + " " + map.get(key));
        }

    }
}

/*
* 结果
        --------------------------------
        遍历map方法1,将key转换成set
        1 张三丰
        2 周芷若
        3 汪峰
        4 灭绝师太
        --------------------------------
        遍历map方法2,将map集合转换成set
        1 张三丰
        2 周芷若
        3 汪峰
        4 灭绝师太
        --------------------------------
        插入编码为5姓名为郭靖的信息(方法1)
        1 张三丰
        2 周芷若
        3 汪峰
        4 灭绝师太
        5 郭靖
        --------------------------------
        移除该map中的编号为1的信息(方法2)
        2 周芷若
        3 汪峰
        4 灭绝师太
        5 郭靖
        --------------------------------
        将map集合中编号为2的姓名信息修改为周林(方法1)
        2 周林
        3 汪峰
        4 灭绝师太
        5 郭靖
*/
