package RedoHomework.hList;

/*
    6.定义一个泛型为String类型的List集合，统计该集合中每个字符
    （注意，不是字符串）出现的次数。例如：集合中有”abc”、”bcd”两个元素，
    程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。
*/

/*
* 思路
*   1   list-->char[][]-->char[]
*   2   char[]升序排列Arrays.sort()      得到最大字母与最小字母差值
*   3   int[]长度为差值+1    字母-最小字母为下标  存放的integer为出现次数
*   4   遍历输出int[]
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterOccurrences {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc");
        list.add("abc");
        list.add("def");
        list.add("def");
        list.add("ghi");

        //list中字符串转化为char存入二维数组
        char[][] letter = new char[list.size()][3];
        for (int i = 0; i < letter.length; i++) {
            letter[i] = list.get(i).toCharArray();
        }

        /*System.out.println("list中字符串");
        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {
                System.out.print(letter[i][j]+" ");
            }
            System.out.println(" ");
        }*/

        //将二维数组转化为一维数组
        char[] letters = new char[3*list.size()];
        int k = 0;
        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i].length; j++) {
                letters[k++] = letter[i][j];
            }
        }

        //一维数组升序排列
        Arrays.sort(letters);

        //
        int length = letters[letters.length-1] - letters[0];

        int[] occurrences = new int[length+1];
        for (int i = 0; i < letters.length; i++) {
            occurrences[(letters[i] - letters[0])]++;
        }

        System.out.println("=========================================");
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] != 0){
                System.out.println( (char)(i+letters[0]) + " = " + occurrences[i] );
            }
        }
    }
}
