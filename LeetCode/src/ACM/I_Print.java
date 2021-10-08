package ACM;

/*
    打字
        字符串只包括大小写字母
        按下CapsLock键，可以切换大小写模式。
        我们在小写模式时候，同时按下shift+字母键，就能写出大写字母。
        在大写模式的时候，按下shift+字母键，就能写出小写字母。
        现在问题来了，给你一个字符串，问你最少使用多少个按键，就可以写出这个字符串呢？
        注意，按shift和字母键，算两次按键。开始时均为小写状态。

    输入描述
        第一行一个T，表示有T组输入。
        接下来T组数据：
        每组数据一个字符串s，s的长度小于等于100。仅包含大小写字母。
3
A
aa
ahOHJiugUuiGUI

    输出描述
        对于每组数据，输出最少按键次数。
*/

import java.util.Scanner;

public class I_Print {
// public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //while (cin.hasNext()){

            // 接收输入
            int inputNum = cin.nextInt();
            String[] strings = new String[inputNum];
            for (int i = 0; i < inputNum ; i++) {
                strings[i] = cin.next();
                numberOfType(strings[i]);
            }

        //}
    }

    /**
     * 计算输入字符串的最少按键次数并输出
     * */
    private static void numberOfType(String string) {

        // 默认字符串全小写
        // 大小写模式默认为false，即小写模式
        // 初始按键次数为字符串长度
        boolean capsLock = false;
        int len = string.length(), numOfType = len;

        // 遍历字符串到倒数第二位
        for (int i = 0; i < len-1 ; i++) {

            if (!capsLock){
                // 小写模式下
                if (Character.isUpperCase(string.charAt(i))){
                    // 若小写模式下只出现一个大写字母，num+1即可，表示shift+字母
                    // 若出现连续大写字母，num+1，置标记为真，表示按CapsLock切换成大写模式
                    numOfType++;
                    if (Character.isUpperCase(string.charAt(i+1))){
                        capsLock = true;
                    }
                }
            }else {
                // 大写模式下
                if (Character.isLowerCase(string.charAt(i))){
                    // 若大写模式下只出现一个小写字母，num+1即可，表示shift+字母
                    // 若出现连续小写字母，num+1，置标记为假，表示按CapsLock切换成小写模式
                    numOfType++;
                    if (Character.isLowerCase(string.charAt(i+1))){
                        capsLock = false;
                    }
                }
            }
        }

        // 遍历结束，查看最后一位字符
        if (capsLock){
            // 大写模式下，最后一位小写，num+1
            if (Character.isLowerCase(string.charAt(len-1))){
                numOfType++;
            }
        }else {
            // 小写模式下，最后一位大写，num+1
            if (Character.isUpperCase(string.charAt(len-1))){
                numOfType++;
            }
        }

        System.out.println(numOfType);

    }

    /*private static void numberOfType(String string) {

        *//*
        1.  开始时为小写模式
        2.  若字符为小写字母，每一个字母按键一次
            若字符为大写字母，可以同时按下shift+字母键，或者按下CapsLock键切换成大写模式
        3.  若大小写混合，出现大写字母
            1.  按下shift+字母键，每一个大写字母为两次
            2.  切换大写模式，一次C，字母个数，一次C（若后面没有小写，不必切换回来）
                出现大写字母必须按C，次数至少加一
        4.  连续大写字母情况（s/c）
            1.  1个=2,2/3
            2.  2个=4,3/4
            3.  3个=6,4/5
            4.  大写字母一个按下shift+字母键，两个及以上切换成大写模式
        5.  储存连续大写字符个数，遇到小写统一计算
        *//*

        // 初始化结果为0，连续大写字符个数0
        int numOfType = 0, consecutiveUpper = 0;

        // 遍历字符串
        for (int i = 0; i < string.length(); i++) {
            // 取出第i位字母，判断大小写
            char c = string.charAt(i);
            if (Character.isLowerCase(c)){
                // 当前字母是小写字符，若前面无连续大写，按键次数加一
                if (consecutiveUpper==0){
                    numOfType++;
                }else if (consecutiveUpper==1){
                    // 连续大写字符个数非零，即前方有连续大写字符，在当前字母处结束
                    // 判断，若连续大写字符一个，按键次数+2
                    // 连续大写字符个数归零
                    // 再加上小写字母一个
                    numOfType +=2;
                    consecutiveUpper = 0;
                    numOfType++;
                }else {
                    // 若连续大写字符大于一个，按键次数+（连续大写字符个数+2）
                    // 连续大写字符个数归零
                    // 再加上小写字母一个
                    numOfType = numOfType + consecutiveUpper + 2;
                    consecutiveUpper = 0;
                    numOfType++;
                }
            }else {
                // 当前字母是大写字符，连续大写字符个数加一
                consecutiveUpper++;
            }
        }

        // 若字符串遍历完毕，连续大写字符个数非零，即连续大写字符到字符串末尾结束
        // 按键次数+（连续大写字符个数+1），因为不必切换回小写模式
        if (consecutiveUpper!=0){
            numOfType = numOfType + consecutiveUpper + 1;
        }

        System.out.println(numOfType);

    }
*/
}
