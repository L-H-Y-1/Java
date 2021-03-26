package String;

/*
    387. 字符串中的第一个唯一字符
        给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

    解题思路

        1. s为空返回-1,s只有一个字符返回0
        2. 使用map的key储存字符,value储存次数
        3. 或者使用数组,字符-‘a’作为下标,存放次数
        4. 遍历字符串,第一个map的value=1或者数组元素=1,返回下标

*/

import java.util.HashMap;
import java.util.Map;

public class B_387 {
    public static void main(String[] args) {

        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));

    }

    public static int firstUniqChar(String s) {

        if (s==null ){
            return -1;
        }
        if (s.length()==1){
            return 0;
        }

        // 1 使用map
        /*Map<Character,Integer> map = new HashMap<>();

        for ( char c : s.toCharArray() ) {
            if (map.containsKey(c)){
                int val = map.get(c);
                map.put(c,++val);
            }else{
                map.put(c,1);
            }
        }

        for ( char c : s.toCharArray() ) {
            if (map.get(c)==1){
                return s.indexOf(c);
            }
        }*/

        // 2 使用数组
        int[] array = new int[26];
        for ( char c : s.toCharArray() ) {
            array[c-'a']++;
        }

        for ( char c : s.toCharArray() ) {
            if (array[c-'a'] == 1){
                return s.indexOf(c);
            }
        }

        return -1;
    }

}
