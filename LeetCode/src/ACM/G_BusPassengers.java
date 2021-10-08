package ACM;

/*
    公交车乘客
        一个公交车经过n个站点，乘客从前门上车，从后门下车。
        现在统计了在第i个站，下车人数a[i]，以及上车人数b[i]。
        问公交车运行时候车上最多有多少乘客

    输入
        第一行读入一个整数n(1<=n<=100)，表示有n个站点
        接下来n行，每行两个数值，分别表示在第i个站点下车人数和上车人数

    输出
        每组输出车上最多的乘客数目
*/

import java.util.Scanner;

public class G_BusPassengers {
// public class Main {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        // 读取输入
        while (cin.hasNext()){

            // 站点个数
            int stationNum = cin.nextInt();
            // 初始化列车人数为num，最大人数为maxNum
            int num = 0,maxNum = 0;
            // 数组存放下车和上车人数
            int[] getOff = new int[stationNum];
            int[] getOn = new int[stationNum];
            // 遍历读取下车和上车人数并计算
            for (int i = 0; i < stationNum ; i++) {
                getOff[i] = cin.nextInt();
                getOn[i] = cin.nextInt();
                num += getOn[i] - getOff[i];
                maxNum = num>maxNum ? num : maxNum;
            }
            System.out.println(maxNum);

        }

    }
}
