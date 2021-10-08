package ACM;

/*
    约德尔测试

    黑默丁格曾经提出了一个约德尔测试，将约德尔人的历史的每个阶段都用一个字符表达出来。(包括可写字符,不包括空格。)。
    然后将这个字符串转化为一个01串。转化规则是如果这个字符如果是字母或者数字，这个字符变为1,其它变为0。
    然后将这个01串和黑默丁格观测星空得到的01串做比较，得到一个相似率。相似率越高,则约德尔的未来越光明。
    请问:相似率为多少？

    输入
        每组输入数据为两行，第一行为有关约德尔人历史的字符串，第二行是黑默丁格观测星空得到的字符串。
        (两个字符串的长度相等,字符串长度不小于1且不超过1000。)

    输出
    输出一行，在这一行输出相似率。用百分数表示。
    (相似率为相同字符的个数/总个数,精确到百分号小数点后两位。printf("%%");输出一个%。)

    样例输入
@!%12dgsa
010111100

    样例输出
        66.67%

    注：
        判断是否是数字或字母：isLetterOrDigit(ch)
        使用printf输出两位小数的百分数：System.out.printf("%.2f%%",rate)

*/

import java.util.Scanner;

import static java.lang.Character.isLetterOrDigit;

public class C_YodelTest {
//public class Main {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        String yodel = cin.nextLine();
        String starSky = cin.nextLine();

        // 转换约德尔串
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < yodel.length(); i++) {
            char ch = yodel.charAt(i);
            if (isLetterOrDigit(ch)){
                str.append(1);
            }else {
                str.append(0);
            }
        }
        /*System.out.println(yodel);
        System.out.println(str);
        System.out.println(starSky);*/

        // 比较
        int num = 0;
        for (int i = 0; i < starSky.length(); i++) {
            char c1 = str.charAt(i);
            char c2 = starSky.charAt(i);
            if (c1==c2){
                num++;
            }
        }

        // 注意输出格式，使用printf保留两位小数：System.out.printf("%.2f%%",rate)
        float rate = (float)100*num/(float)starSky.length();
        System.out.printf("%.2f%%",rate);

    }
}
