package ACM;

/*
    计算器的新功能

        当你学一些可视化程序设计语言时，老师经常会让你设计并且编程做出一个计算器，
        这时也许你会仿照windows系统自带的计算器外观和功能去设计，
        但是现在老师要你多做出一个有新功能的计算器，
        实现当输入一个数时，能够将这个数分解成一个或多个素因子乘积的形式，并按素因子的大小排列显示出来。
        大家对计算器中数的表示应该很清楚的。
        下面显示出了0 — 9这十个数字的表示形式。每个数字都占据5 * 3大小的字符区域

    输入
        输入有多组测试数据，每组包括一个正整数n（1 < n <= 1000000)。

    输出
        对于每个数，将它分解成若干个素数乘积的形式，并按从小到大的顺序输出，素因子之间用“ * ”的形式连接。

    注：
        写上while (cin.hasNext()){}

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E_NewFuctionOfCaculater {
//public class Main {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            int num = cin.nextInt();
            // 分解因式
            List deposeList = depose(num);
            // 输出图形
            printRes(deposeList);
        }
    }

    // 分解因式
    private static List depose(int num) {

        List deposeList = new ArrayList();

        // 因子最小是2，最大是num本身，因此从2遍历至num
        int primer = 2;
        while (primer<=num){

            if (primer==num){
                deposeList.add(primer);
                break;
            }else if (num%primer==0){
                // 如果num能够整除primer，说明当前数值是因子之一
                // 将因子加入list，并更新num，继续判断当前数值是否是新num的因子
                deposeList.add(primer);
                num = num/primer;
            }else {
                // 如果num不能够整除primer，说明当前数值不是因子，primer+1，继续判断
                primer++;
            }

        }

        return deposeList;

    }

    // 输出图形
    private static void printRes(List deposeList) {

        int length = deposeList.size();

        // 初始化0-9数字的图案，共5行
        String[] line1 = {" - ","   "," - "," - ","   "," - "," - "," - "," - "," - "};
        String[] line2 = {"| |","  |","  |","  |","| |","|  ","|  ","  |","| |","| |"};
        String[] line3 = {"   ","   "," - "," - "," - "," - "," - ","   "," - "," - "};
        String[] line4 = {"| |","  |","|  ","  |","  |","  |","| |","  |","| |","  |"};
        String[] line5 = {" - ","   "," - "," - ","   "," - "," - ","   "," - "," - "};


        // 初始化输出图案，共5行
        StringBuffer print1 = new StringBuffer();
        StringBuffer print2 = new StringBuffer();
        StringBuffer print3 = new StringBuffer();
        StringBuffer print4 = new StringBuffer();
        StringBuffer print5 = new StringBuffer();

        // 拼接输出图案
        for (int i = 0; i < length; i++) {
            // 遍历因子列表，取出因子factor，转成String
            String factor = deposeList.get(i).toString();
            // 遍历因子每一位（例：因子为234，遍历输出2,3,4）
            for (int j = 0; j < factor.length(); j++) {
                // 取出因子第j位factor.charAt(j)，例：234第0位是字符'2'
                // 计算下标，例：字符'2'的图案下标是整形数2
                // 输出行拼接相应图案
                print1.append(line1[factor.charAt(j)-'0']);
                print2.append(line2[factor.charAt(j)-'0']);
                print3.append(line3[factor.charAt(j)-'0']);
                print4.append(line4[factor.charAt(j)-'0']);
                print5.append(line5[factor.charAt(j)-'0']);
            }
            // 当前因子拼接完成后，拼接“*”
            print1.append(" ");
            print2.append(" ");
            print3.append("*");
            print4.append(" ");
            print5.append(" ");

        }

        // 去除最后一位
        int len = print1.length();
        print1.deleteCharAt(len-1);
        print2.deleteCharAt(len-1);
        print3.deleteCharAt(len-1);
        print4.deleteCharAt(len-1);
        print5.deleteCharAt(len-1);

        // 输出图案
        System.out.println(print1);
        System.out.println(print2);
        System.out.println(print3);
        System.out.println(print4);
        System.out.println(print5);

    }

}
