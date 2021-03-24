package Array;

import java.util.ArrayList;
import java.util.List;

/*
    6.Z字形变换

        将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
        比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
        P   A   H   N
        A P L S I I G
        Y   I   R
        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

    解题思路

        1.奇偶数判断，二维数组储存

            1. 如果s为空，或者s只有一个字符，或者行数为1，或者行数比s长，返回s
            2. 新建二维数组
            3. 遍历s，用下标除(行数-1)，商为第几列，余数为该列第几个
            4. 商为偶数，字符存放在数组[余数][商]中(正序)
            5. 商为奇数，字符存放在数组[行数-1-余数][商]中(倒序)
            6. 将二维数组按行拼接字符串

            改进:
                    使用存放StringBuilder的list节省空间
                    用flag判断行指针移动方向

        2. flag判断，list按行储存

            1. 如果s为空，或者s只有一个字符，或者行数为1，或者行数比s长，返回s
            2. 新建存放StringBuilder的list，初始化为numRows个new StringBuilder()
            3. 设置flag和count(行数指针)
            4. 遍历s，list第count个StringBuilder拼接字符
            5. flag为true，指针向下移动，flag为false，指针向上移动
            6. 行数为0或numRows-1，flag取反
            7. list按行拼接字符串

*/

public class I_6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String string = convert(s,numRows);
        System.out.println(string);
    }

    public static String convert(String s, int numRows) {

        if ( null == s || s.length()==1 || numRows==1 || s.length()<=numRows ){
            return s;
        }

        // 1
        /*char[][] chars = new char[numRows][ (s.length()/(numRows-1)+1)];
        for (int i = 0; i < s.length(); i++) {

            int quotient = i / (numRows-1) ;
            int remainder = i % (numRows-1) ;

            if (quotient%2 == 0){
                chars[remainder][quotient] = s.charAt(i);
            }else{
                chars[numRows-1-remainder][quotient] = s.charAt(i);
            }

        }


        String string = "";
        //System.out.println("--------------------");
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                //System.out.print(chars[i][j] + " ");
                if (0 != chars[i][j]){
                    string += chars[i][j];
                }
            }
            //System.out.println(" ");
        }
        //System.out.println("--------------------");

        return string;*/

        //2
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder()) ;
        }

        boolean flag = false;
        int count = 0;
        for ( char c : s.toCharArray() ) {
            list.get(count).append(c);
            if (count==0 || count==numRows-1){
                flag = !flag;
            }
            count += flag ? 1 : -1 ;
        }

        StringBuilder result = new StringBuilder();
        for ( StringBuilder str : list  ) {
            result.append(str);
        }

        return result.toString();
    }

}
