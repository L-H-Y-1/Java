package ACM;

/*
    路灯

        V先生有一天工作到很晚，回家的时候要穿过一条长l的笔直的街道，这条街道上有n个路灯。
        假设这条街起点为0，终点为l，第i个路灯坐标为ai。
        路灯发光能力以正数d来衡量，其中d表示路灯能够照亮的街道上的点与路灯的最远距离，所有路灯发光能力相同。
        为了让V先生看清回家的路，路灯必须照亮整条街道，又为了节省电力希望找到最小的d是多少？

        输入
            输入两行数据，第一行是两个整数：路灯数目n (1≤n≤1000)，街道长度l (1 ≤l≤109)。
            第二行有n个整数ai (0 ≤ ai≤ l)，表示路灯坐标，多个路灯可以在同一个点，也可以安放在终点位置。

        输出
            输出能够照亮整个街道的最小d，保留两位小数。

        样例输入
7 15
15 5 3 7 9 14 0

        样例输出
        2.50


*/

import java.util.Arrays;
import java.util.Scanner;

public class D_StreetLight {
//public class Main {
    public static void main(String[] args) {

        // 输入路灯数量，街道长度，路灯坐标
        Scanner cin = new Scanner(System.in);
        int lightNum = cin.nextInt();
        int length = cin.nextInt();
        int[] lightCoordinates = new int[lightNum];
        for (int i = 0; i < lightNum; i++) {
            lightCoordinates[i] = cin.nextInt();
        }

        // 排序
        Arrays.sort(lightCoordinates);

        // 计算最大路灯间距(除2)
        double maxSpace = 0.0f;
        for (int i = 1; i < lightNum; i++) {
            if (lightCoordinates[i] - lightCoordinates[i-1]>maxSpace){
                maxSpace = lightCoordinates[i] - lightCoordinates[i-1];
            }
        }
        maxSpace = maxSpace/2.0;

        // 计算最大边界
        double border = Math.max(lightCoordinates[0], length-lightCoordinates[lightNum-1]);

        // 输出较大的值
        double res = maxSpace>border ? maxSpace : border;
        System.out.printf("%.2f",res);

    }
}
