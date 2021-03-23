package RedoHomework.hList;

/*
1.产生10个1-100的随机数，并放到一个数组中，把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {

        //创建随机数对象和数组
        Random random = new Random();
        int[] randomArray = new int[10];

        //初始化为-1
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = -1;
        }

        //产生10个随机数放入数组
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(101);
        }

        //打印所有元素
        System.out.println("数组中的元素为");
        for (int i = 0; i < randomArray.length; i++) {
            System.out.print(randomArray[i]+" ");
        }
        System.out.println(" ");

        //--------------------------------------

        //创建ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        //大于10的随机数放入list中
        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] > 10){
                arrayList.add(randomArray[i]);
            }
        }

        //遍历集合
        Iterator iterator = arrayList.iterator();
        System.out.println("集合中的元素为");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

    }
}
