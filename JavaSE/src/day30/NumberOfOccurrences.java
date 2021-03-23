/*
6.定义一个泛型为String类型的List集合，统计该集合中每个字符
（注意，不是字符串）出现的次数。例如：集合中有”abc”、”bcd”两个元素，
程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。
*/

/*
* 思路
* 1 将集合转为二维数组chars
*       每个长度为3的字符串转化为一个长度为3一维char数组
*       集合中list.size()个字符串转为list.size()*3二维char数组
* 2 将二维数组chars转化为一维数组letters
*       创建一维数组letters
*       遍历chars,赋值给letters
* 3 一维数组letters升序排列
* 4 统计数组中的字符出现次数
*       创建计数数组numbers,长度为letters中最大元素-最小元素
*       将letters[i]-letters[0]作为numbers的下标
*       元素出现一次,numbers[letters[i]-letters[0]]++;
* 5 遍历输出计数数组numbers
*       遍历numbers
*       判断是否为0,是则continue
*       否则输出(char)(i + letters[0])与数量numbers[i]
* */

package day30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfOccurrences {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bcd");
        list.add("cde");
        list.add("def");

        list.add("opq");
        list.add("pqr");
        list.add("xyz");


        //遍历list将字符串转化为二维数组
        System.out.println("--------------------------------");
        System.out.println("遍历list");
        char[][] chars = new char[list.size()][3];
        for (int i = 0; i < list.size() ; i++) {
            //得到字符串
            String s = list.get(i);
            System.out.println(s);
            //将字符串转化为char数组
            chars[i] = s.toCharArray();
        }

        //将二维数组转为一维数组
        char[] letters = new char[ 3*list.size() ];
        int k = 0 ;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                letters[k++] = chars[i][j];
            }
        }

        //排序遍历一维数组
        Arrays.sort(letters);
        int max = letters[letters.length-1] - letters[0];
        System.out.println("--------------------------------");
        System.out.println("升序一维数组");
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i] + " ");
        }
        System.out.println(" ");

        //统计数组中的字符出现次数
        int[] numbers = new int[max+1];
        for (int i = 0; i < letters.length; i++) {
            numbers[letters[i] - letters[0]]++;
        }

        //遍历输出字符及其出现次数
        System.out.println("--------------------------------");
        System.out.println("统计字符及其出现次数");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                continue;
            }else{
                System.out.println( "字符" + (char)(i + letters[0]) + "出现了" + numbers[i] + "次");
            }
        }
        System.out.println("--------------------------------");

    }
}

/*
结果
        --------------------------------
        遍历list
        abc
        bcd
        cde
        def
        opq
        pqr
        xyz
        --------------------------------
        升序一维数组
        a b b c c c d d d e e f o p p q q r x y z
        --------------------------------
        统计字符及其出现次数
        字符a出现了1次
        字符b出现了2次
        字符c出现了3次
        字符d出现了3次
        字符e出现了2次
        字符f出现了1次
        字符o出现了1次
        字符p出现了2次
        字符q出现了2次
        字符r出现了1次
        字符x出现了1次
        字符y出现了1次
        字符z出现了1次
        --------------------------------

*/
