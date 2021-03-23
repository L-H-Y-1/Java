/*2.已知数组存放一批QQ号码，QQ号码最长为11位，最短为5位String[] strs =
{"12345","67891","12347809933","12345","98765432102","67891","12347809933","12345"}。
将该数组里面的所有qq号都存放在LinkedList中，将重复元素删除，分别用迭代器和增强for循环打印出来。*/

/*
* 思路
* 1 创建数组存放号码,创建链表集合,遍历数组,将号码存入链表集合
* 2 迭代器遍历集合
*       获取迭代器对象
*       通过迭代器对象遍历集合
* 3 删除重复元素
*       通过下标遍历集合
*           取出当前下标元素
*           循环{
*               取出当前元素第一次和最后一次出现的下标
*               若不同,删除最后一次出现下标的元素,继续循环
*               若相同,跳出循环
*           }
* 4 foreach遍历集合
* */

package day30;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DeleteRepeat {
    public static void main(String[] args) {

        //创建数组
        String[] strings = {"12345","67891","12347809933","12345","98765432102","67891","12347809933","12345"};

        //创建链表集合
        List<String> list = new LinkedList<>();

        //遍历数组,将号码存入链表
        for (int i = 0; i < strings.length ; i++) {
            list.add(strings[i]);
        }

        //迭代器遍历链表集合
        System.out.println("链表集合中元素为:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.print(object + " ");
        }
        System.out.println(" ");
        System.out.println("-------------------------");

        //遍历链表集合,删除重复元素
        for (int i = 0; i < list.size(); i++) {
            String number = list.get(i);
            while (true) {
                int firstIndex = list.indexOf(number);
                int lastIndex = list.lastIndexOf(number);
                if (firstIndex == lastIndex) {
                    break;
                }else{
                    list.remove(lastIndex);
                }
            }
        }

        //foreach遍历链表集合
        System.out.println("删除重复元素后链表集合:");
        for (String s : list ) {
            System.out.print(s + " ");
        }
        System.out.println(" ");
        System.out.println("-------------------------");

    }
}

/*
        链表集合中元素为:
        12345 67891 12347809933 12345 98765432102 67891 12347809933 12345
        -------------------------
        删除重复元素后链表集合:
        12345 67891 12347809933 98765432102
        -------------------------
*/
