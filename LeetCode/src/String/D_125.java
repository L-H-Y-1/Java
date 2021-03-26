package String;

/*
    125. 验证回文串

        给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
        说明：本题中，我们将空字符串定义为有效的回文串。

    解题思路

        1. 字符串转小写                      ----s.toLowerCase()方法
        2. new一个StringBuilder串res
        3. 遍历字符串,字符是字母数字就拼接到res  ---- Character.isLetterOrDigit(c)方法

        1.双指针
            1. 左指针0, 右指针指向最后一个字符
            2. 双指针对比字符是否相等
            3. 相等则向中间移动,直至双指针相遇
            4. 不等就返回false

        2. 反转字符串
            1. new一个StringBuilder串res2为res的反转字符串
                    注意StringBuilder的反转方法
                    ----StringBuilder res2 = new StringBuilder(res).reverse();
            2. 判断res和res2是否相等,相等就是回文串
                    注意要先toString()再比较相等
                    ----res.toString().equals(res2.toString())

*/

public class D_125 {
    public static void main(String[] args) {

        //String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        //String s = ",.";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();
        StringBuilder res = new StringBuilder();
        for ( char c : s.toCharArray() ) {
            if (Character.isLetterOrDigit(c)){
                res.append(c);
            }
        }

        // 1 双指针
        /*int left = 0 , right = res.length()-1 ;
        while (left<right){
            if (res.charAt(left)==res.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }*/

        // 2 反转字符串
        StringBuilder res2 = new StringBuilder(res).reverse();
        if (!(res.toString().equals(res2.toString()))){
            return false;
        }

        return true;

    }

}
