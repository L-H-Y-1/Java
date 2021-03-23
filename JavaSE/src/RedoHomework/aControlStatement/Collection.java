package RedoHomework.aControlStatement;

import java.util.Scanner;

/**
 * 题目
 * 1 计算1000以内所有不能被7整除的整数之和
 * 2 计算 1+2-3+4-5+6-7....+100的结果
 * 3 计算阶乘
 * 4 判断质数
 * 5 打印*
 * 6 给出位数和各位数字
 * 7 判断回文数
 * 8 找出1000以内所有完数
 * */

public class Collection {
    public static void main(String[] args) {

        //选择题目
        System.out.println(" * * * * * * * * * *\n" +
                " * 1 计算1000以内所有不能被7整除的整数之和\n" +
                " * 2 计算 1+2-3+4-5+6-7....+100的结果\n" +
                " * 3 计算阶乘\n" +
                " * 4 判断质数\n" +
                " * 5 打印*\n" +
                " * 6 给出位数和各位数字\n" +
                " * 7 判断回文数\n" +
                " * 8 找出1000以内所有完数\n" +
                " * 0 退出\n" +
                " * * * * * * * * * *" );

        while (true){
            System.out.println("Please chose a question ( 0-8 ) ");
            Scanner scanner = new Scanner(System.in);
            int question = scanner.nextInt();
            System.out.println("-------------------------------");

            switch (question){
                case 0: return;
                case 1: question1();    break;  //429429
                case 2: question2();    break;  //52
                case 3: question3();    break;
                case 4: question4();    break;
                case 5: question5();    break;
                case 6: question6();    break;
                case 7: question7();    break;
                case 8: question8();    break;  //6 28 496
                default:
                    System.out.println("The input is illegal");
            }
        }

    }


    /**
     * 1 计算1000以内所有不能被7整除的整数之和
     */
    public static void question1(){
        int sum = 0;
        for (int i = 1; i < 1001 ; i++) {
            if ( i % 7 != 0){
                sum += i;
            }
        }
        System.out.println("1000以内所有不能被7整除的整数之和:" + sum );
        System.out.println("-------------------------------");
    }

    /**
     * 2 计算 1+2-3+4-5+6-7....+100的结果
     */
    public static void question2(){
        int sum = 1;
        for (int i = 2; i <= 100; i++) {
            if ( i % 2 == 0){
                sum += i;
            }else{
                sum -= i;
            }
        }
        System.out.println("1+2-3+4-5+6-7....+100=" + sum);
    }

    /**
     * 3 计算阶乘
     * */
    public static void question3(){
        System.out.print("Please input a integer:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        long result = 1L;
        for (int i = num; i > 0 ; i-- ) {
            result *= i ;
        }
        System.out.println( num + "的阶乘是:" + result );
    }

    /**
     * 4 判断质数
     * */
    public static void question4(){
        System.out.print("Please input a positive number:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        boolean flag = true;
        if ( num == 1){
            System.out.println("1不能作为质数");
            return;
        }
        if ( num == 2 ){
            System.out.println("2是质数");
            return;
        }

        for (int i = 2; i <= ( num/2 ); i++) {
            if ( num % i == 0){
                flag = false;
                break;
            }
        }
        System.out.println( num + ( flag ? "是" : "不是" ) + "质数");
    }

    /**
     * 5 打印*
     * */
    public static void question5(){
        System.out.print("Please input a positive number:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*(i-1)+1 ; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*(num-i-1)+1 ; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    /**
     * 6 给出位数和各位数字
     * */
    public static void question6(){
        System.out.print("Please input a positive number:");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();

        char[] chars = num.toCharArray();
        System.out.println("位数是" + chars.length);
        System.out.println("各位数字分别是");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ,");
        }
        System.out.println(" ");

        System.out.println("反转字符串");
        String string = " ";
        for (int i = 0; i < chars.length; i++) {
            string += chars[chars.length - i - 1];
        }
        System.out.println(string);

    }

    /**
     * 7 判断回文数
     * */
    public static void question7(){
        System.out.print("Please input a positive number:");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();

        boolean flag = false;
        char[] chars = num.toCharArray();
        String string = "";
        for (int i = 0; i < chars.length; i++) {
            string += chars[chars.length - i - 1];
        }
        System.out.println("反转字符串为: " + string);
        if (num.equals(string)){
            flag = true;
        }
        System.out.println(num + (flag ? "是" : "不是") + "回文数");
    }

    /**
     * 8 找出1000以内所有完数
     * */
    public static void question8() {
        System.out.println("1000以内所有完数:");
        for (int i = 2; i <= 1000; i++) {
            int sum = 1;
            for (int j = 2; j <= i/2 ; j++) {
                if ( i % j == 0){
                    sum += j;
                }
            }
            if (sum == i){
                System.out.print( i + " ");
            }
        }
        System.out.println(" ");
    }
}
