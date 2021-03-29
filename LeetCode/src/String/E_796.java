package String;

/*
    796. 旋转字符串

        给定两个字符串, A 和 B。
        A 的旋转操作就是将 A 最左边的字符移动到最右边。 
        例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
        如果在若干次旋转操作之后，A 能变成B，那么返回True。

    解题思路

        1. A旋转得到的所有字符串都是A+A的子串
        2. 如果长度相等且B是A+A的子串,则返回true

*/

public class E_796 {
    public static void main(String[] args) {

        String A = "aa";
        String B = "a";
        System.out.println(rotateString(A,B));

    }

    public static boolean rotateString(String A, String B) {

        /*if (A.length() != B.length()){
            return false;
        }

        if ((A+A).contains(B)){
            return true;
        }else {
            return false;
        }*/

        return (A.length() == B.length()) && ((A+A).contains(B));

    }

}
