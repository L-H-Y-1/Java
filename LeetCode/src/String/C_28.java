package String;

/*
    28. 实现 strStr()

        实现 strStr() 函数。给定一个 haystack 字符串和一个 needle 字符串，
        在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

    解题思路

        1. 遍历haystack到下标haystack.length()-needle.length()+1
        2. 比较haystack下标从i到i+needle.length()的子串与needle是否相等
        3. 相等返回i

*/

public class C_28 {
    public static void main(String[] args) {

        String haystack = "mississippi", needle = "mississippi" ;
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {

        // 直接使用indexOf()方法
        /*if (!haystack.contains(needle)){
            return -1;
        }

        return haystack.indexOf(needle);*/

        // 自己实现indexOf()方法

        System.out.println(needle+"------");
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {

            System.out.println(haystack.substring(0,i));
            System.out.println(needle+"------");
            if (haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }

        }

        return -1;

    }

}
