package String;

/*
    344. 反转字符串

        编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
        不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
        你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

    解题思路

        1. 设置首尾指针
        2. 双指针指向的元素交换
        3. 直至数组的一半或者首指针>=尾指针

*/

public class A_344 {
    public static void main(String[] args) {

        char[] s = {'h','e','l','l','o'};
        //char[] s = {'S','a','m','e','e','n'};
        //char[] s = {'a','b','c','d','e','f'};
        //char[] s = {'a','b','c','d','e','f','g'};
        for (int i = 0; i < s.length ; i++) {
            System.out.print(s[i]);
        }
        System.out.println("---------------");

        reverseString(s);

        for (int i = 0; i < s.length ; i++) {
            System.out.print(s[i]);
        }
    }

    public static void reverseString(char[] s) {

        // 1 首尾指针
        char letter = 0;

        /*for (int i = 0; i <= (s.length-1)/2 ; i++) {
            System.out.println(s[i]);
            letter = s[i];
            s[i] = s[s.length-1-i] ;
            s[s.length-1-i] = letter;
        }*/

        // 2
        int first = 0 , last = s.length-1 ;

        while ( first < last ) {
            letter = s[first];
            s[first] = s[last] ;
            s[last] = letter;
            first++ ;
            last--;
        }

    }

}
