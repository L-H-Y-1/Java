package WrittenTest.Baidu;
/*
    容易等级 ac
        Kimi的英语老师是一个非常有趣的人。每一次考试之前她都会在不经意间透露一下试题的难度，她会在黑板上写一串长长的字符。你需要从这串字符中按照次序找到E或e、A或a、S或s、Y或y这四个字母，每四个字母为一组，将构成一个大家熟悉的单词（easy）。每找到一组字母，即构成一个单词easy则容易等级加1。当然，容易等级越大就意味着考试题目越容易，所以Kimi希望能够从中找到最多的字母组合。值得注意的是如果有多于一个easy，每一个easy都需要按照次序出现，也就是说下一个easy中的“e”必须在前一个easy中的“y”之后出现。 你能否编写一个程序告诉Kimi这次英语考试的容易等级是多少呢？
*/

import java.util.Scanner;

public class Rate {
// public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){

            // 读取字符串 转成小写字符数组
            String s = cin.next();
            s = s.toLowerCase();
            char[] chars = s.toCharArray();
            int res = 0;
            int flag = 0;

            for (int i = 0; i < chars.length; i++) {
                // 遍历字符数组
                // 若flag==0且字符为e，flag++
                if (flag==0 && chars[i]=='e'){
                    flag = 1;
                }else if (flag==1 && chars[i]=='a'){
                    flag = 2;
                }else if (flag==2 && chars[i]=='s'){
                    flag = 3;
                }else if (flag==3 && chars[i]=='y'){
                    flag = 0;
                    res++;
                }
            }

            System.out.println(res);


        }
    }
}
