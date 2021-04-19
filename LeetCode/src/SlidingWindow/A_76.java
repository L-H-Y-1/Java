package SlidingWindow;

/*
    76. 最小覆盖子串

        给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
        如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
        注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

    解题思路

        #### 1.初始化设置map

            1. tMap记录t中字符出现次数
            2. windowMap记录窗口中相应字符出现次数


        #### 2. minWindow()方法
            1. 初始化tMap,key中存放t中所有字符,value中存放相应字符出现次数
            2. 初始窗口[left,right)为[0,0)
            3. 初始化最小覆盖子串的首尾下标start=0, end=Integer.MAX_VALUE
            4. 当窗口右端不越界时移动窗口
                1. 从第一个字符开始,取字符c并扩大窗口右边界
                2. 如果c为t中字符,则将窗口map中相应value+1
                3. 如果窗口完全覆盖t且窗口不空,缩小左边界
                    1. 若当前窗口长度小于最小覆盖子串长度,更新最小覆盖子串为当前窗口
                    2. 取字符d并缩小左边界
                    3. 如果d为t中字符,则将窗口map中相应value-1
            6. 判断
                1. 若end=Integer.MAX_VALUE,说明窗口从未完全覆盖t,不存在最小覆盖子串,返回""
                2. 若end！=Integer.MAX_VALUE,返回最小覆盖子串,首尾下标为start,end
                3. 注:String.substring(start,end)返回的范围是[start,end),左闭右开

        #### 3. check()方法判断当前窗口能否完全覆盖t
            1. 若两map长度不等,直接返回false,表示窗口没有包含t中所有元素
            2. 将tMap转化为set
            3. 遍历
                1. 令c为t中字符,num1为t中c出现的次数
                2. num2为窗口中c出现的次数,若窗口无c,num2=0
                3. 判断
                    1. 若t中c出现的次数<=窗口中c出现的次数,继续
                    2. 若窗口中字符出现次数<t,直接返回false
                4. 返回true

*/

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A_76 {

    //tMap记录t中字符出现次数
    //windowMap记录窗口中相应字符出现次数
    public Map<Character,Integer> tMap = new HashMap<>();
    public Map<Character,Integer> windowMap = new HashMap<>();

    public String minWindow(String s, String t) {

        //初始化t的map
        for ( char c : t.toCharArray() ) {
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }

        //初始窗口[left,right)为空,左闭右开[0,0)
        int left = 0, right = 0;

        //初始化最小覆盖子串的首尾下标
        int start = 0, end = Integer.MAX_VALUE;

        //当窗口右端不越界时移动窗口
        while (right<s.length()){

            //从第一个字符开始,取字符c并扩大窗口右边界
            //窗口为[left,right)
            char c = s.charAt(right);
            right++;

            //判断c是否为t中字符
            if (tMap.containsKey(c)){
                //如果c为t中字符,则将窗口map中相应value+1
                windowMap.put(c, windowMap.getOrDefault(c,0)+1);

            }

            //如果窗口完全覆盖t且窗口不空,缩小左边界
            while (check() && left<right){

                //若当前窗口完全覆盖t,窗口不空,且窗口长度小于最小覆盖子串长度
                //即当前窗口为最小覆盖子串,更新
                if (right-left < end-start){
                    start = left;
                    end = right;
                }

                //取字符d并缩小左边界
                char d = s.charAt(left);
                left++;

                //判断d是否为t中字符
                if (tMap.containsKey(d)){
                    //如果d为t中字符,则将窗口map中相应value-1
                    windowMap.put(d, windowMap.getOrDefault(d,0)-1);
                }

            }

        }

        return end==Integer.MAX_VALUE ? "" : s.substring(start,end);

    }

    /**
     * 判断窗口是否完全覆盖t
     * @return 完全覆盖返回true,否则返回false
     * */
    public boolean check() {

        //若两map长度不等,直接返回false,表示窗口未能完全覆盖t
        if (tMap.size()!=windowMap.size()){
            return false;
        }

        //将tMap转化为set
        Set<Map.Entry<Character,Integer>> entrySet = tMap.entrySet();

        //遍历
        for ( Map.Entry<Character,Integer> node : entrySet  ) {

            //令c为t中字符
            char c = node.getKey();
            //num1为t中c出现的次数
            int num1 = node.getValue();
            //num2为窗口中c出现的次数,若窗口无c,num2=0
            int num2 = windowMap.getOrDefault(c,0);

            //若t中c出现的次数<=窗口中c出现的次数,继续
            //否则,直接返回false,表示窗口未能完全覆盖t
            if (num1>num2){
                return false;
            }

        }

        return true;

    }

}
