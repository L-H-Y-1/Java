/*
1.产生10个1-100的随机数，并放到一个数组中，把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
*/

/*
* 思路
* 1 创建数组和随机数对象,在数组中放入10个0-100随机数
* 2 遍历数组,判断随机数是否大于等于10,是则放入集合中
* 3 遍历集合,输出随机数
* */

package day30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BiggerThanTenTest {
    public static void main(String[] args) {

        //创建数组和随机数对象,在数组中放入10个0-100随机数
        int[] array = new int[10];
        Random random = new Random();
        System.out.println("数组中的随机数为(0-100):");
        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(101);
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");

        //遍历数组,判断随机数是否大于等于10,是则放入集合中
        System.out.println("将大于等于10的随机数放入集合中:");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 10){
                list.add(array[i]);
            }else {
                continue;
            }
        }

        //遍历集合,输出随机数
        Iterator<Integer> iterator = list.iterator();
        while ( iterator.hasNext() ) {
            Object object = iterator.next();
            System.out.print(object + " ");
        }
        System.out.println(" ");

    }
}

/*
结果:
    数组中的随机数为(0-100):
    43 78 1 43 99 78 83 11 96 6
    将大于等于10的随机数放入集合中:
    43 78 43 99 78 83 11 96
*/
