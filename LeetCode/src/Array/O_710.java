package Array;

/*
    710. 黑名单中的随机数

        给定一个包含 [0，n) 中不重复整数的黑名单 blacklist ，
        写一个函数从 [0, n) 中返回一个不在 blacklist 中的随机整数。
        对它进行优化使其尽量少调用系统方法 Math.random() 。

    解题思路

        1. 黑名单排序
        2. 白名单长度为size = 数组[0,n)长度 - 黑名单长度
        2. 令数组[0,size)为A,数组[size,n)为B
        3. A分为白名单a1和黑名单a2,B分为白名单b1和黑名单b2
        4. 设置set存放b1
            1. 先将B全部放入set
            2. set中删除黑名单b2,留下白名单b1
        5. 将a2与b1一一对应
            1. 遍历a2
            2. 将a2与b1对应放入map
        6. 在A中抽取随机数
            1. 若抽到a2,就返回b1中对应数值
            2. 若抽到a1,直接返回

*/

import java.lang.reflect.Array;
import java.util.*;

public class O_710 {

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(n, blacklist);
     * int param_1 = obj.pick();
     */

    /*
    * 思路:
    * 1 数组长度为n,黑名单长度为blacklist.length,白名单长度为size = n - blacklist.length
    * 2 令数组[0,size)为A,数组[size,n)为B
    * 3 A分为白名单a1和黑名单a2(a2数值均<size),B分为白名单b1和黑名单b2
    * 4 将a2与b1一一对应
    * 5 在A中抽取随机数,若抽到a1,直接返回.若抽到a2,就返回b1中对应数值
    * */

    // 设置map存放a2
    Map<Integer,Integer> map = new HashMap<>();
    // 设置set存放b1
    Set<Integer> set = new HashSet<>();
    // 设置size为白名单长度
    int size = 0;
    Random random = new Random();

    public O_710(int n, int[] blacklist) {

        // 黑名单排序
        Arrays.sort(blacklist);
        // size为白名单长度
        size = n - blacklist.length;

        // set存放b1
        // 先将B全部放入set
        for (int i = size ; i < n ; i++) {
            set.add(i);
        }
        // set中删除黑名单b2,留下白名单b1
        for ( Integer num : blacklist    ) {
            set.remove(num);
        }

        // 将a2与b1一一对应
        Iterator<Integer> iterator = set.iterator();
        // 遍历a2
        for (int num : blacklist) {
            if (num<size){
                // 将a2与b1对应放入map
                map.put(num,iterator.next());
            }else {
                break;
            }
        }

    }

    public int pick() {

        // 在A中抽取随机数
        int num = random.nextInt(size);

        if (map.containsKey(num)){
            // 若抽到a2,就返回b1中对应数值
            return map.get(num);
        }else {
            // 若抽到a1,直接返回
            return num;
        }

    }

}
