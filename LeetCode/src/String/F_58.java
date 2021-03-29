package String;

/*

    58. 最后一个单词的长度

        给你一个字符串 s，由若干单词组成，单词之间用空格隔开。
        返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

    解题思路

        1. 去除前后空格 --- s.trim()
        2. 如果字符串全为字母没有空格,返回字符串长度
        3. 从后往前遍历字符串,遇到空格返回最后一位下标-空格下标

*/

public class F_58 {
    public static void main(String[] args) {

        String s = "HelloWorld     ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {

        s = s.trim();

        if (s.matches("^[a-zA-Z]*")){
            return s.length();
        }

        for (int i = s.length()-1 ; i >= 0  ; i--) {
            if (s.charAt(i) == ' '){
                return s.length()-1-i;
            }
        }

        return 0;

    }

}
