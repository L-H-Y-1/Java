package SlidingWindow;

/*
    3. 无重复字符的最长子串

        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    解题思路

        1. 初始化答案res为0
        2. 初始化window存放窗口中的字符及其出现次数
        3. 初始化窗口[0,0)
        4. 当窗口右侧不越界时循环
            1. 取出右侧字符加入窗口
            2. 若字符出现次数>1,收缩左侧边界
                1. 取出左侧字符从窗口移除
            3. 更新res
        5. 返回res

*/

import java.util.HashMap;
import java.util.Map;

public class D_3 {
    public int lengthOfLongestSubstring(String s) {

        int res = 0;

        Map<Character,Integer> window = new HashMap<>();
        int right = 0, left = 0;

        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);

            while (window.get(c)>1){
                char d = s.charAt(left);
                left++;
                window.put(d,window.getOrDefault(d,0)-1);
            }

            res = Math.max(res,right-left);
        }

        return res;

    }
}
