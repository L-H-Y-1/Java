package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*

    438. 找到字符串中所有字母异位词

        给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
        字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
        说明：
            字母异位词指字母相同，但排列不同的字符串。
            不考虑答案输出的顺序。

    解题思路

        1. 新建答案list
        2. base case:p比s长,直接返回空列表
        3. 初始化map
            1. need存放p中所有字符及其出现次数,长度为p中字符数
            2. window中存放窗口中相应字符及其出现次数
        4. 初始化need
        5. 初始窗口[0,0)
        6. 初始化计数器0
        7. 当窗口右端不越界,扩大窗口
            1. 取字符加入窗口,扩大窗口
            2. 更新窗口(先加入再判断)
            3. 当窗口长度不小于p,收缩左边界
                1. 若此时窗口含有p中所有字符且出现次数相等,将窗口左边界加入答案
                2. 取字符并收缩窗口
                3. 更新窗口(先判断再删除)
        8. 返回res

*/

public class C_438 {

    public List<Integer> findAnagrams(String s, String p) {

        //新建答案list
        List<Integer> res = new ArrayList<>();

        //base case
        if (p.length()>s.length()){
            return res;
        }

        //need存放p中所有字符及其出现次数,长度为p中字符数
        //window中存放窗口中相应字符及其出现次数
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        //初始化need
        for ( char c : p.toCharArray() ) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        //初始窗口[0,0)
        int left = 0, right = 0;

        //初始化计数器0
        //当某一字符在窗口中出现次数=p中出现次数,count++
        //count = need.size()时,窗口含有p中所有字符且出现次数相等
        int count = 0;

        //当窗口右端不越界,扩大窗口
        while (right<s.length()){

            //取字符加入窗口,扩大窗口
            char c = s.charAt(right);
            right++;

            //更新窗口
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    count++;
                }
            }

            //当窗口长度不小于p,收缩左边界
            while (right-left >= p.length()){

                //此时窗口含有p中所有字符且出现次数相等,将窗口左边界加入答案
                if (need.size()==count){
                    res.add(left);
                }

                //取字符并收缩窗口
                char d = s.charAt(left);
                left++;

                //更新窗口
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        count--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }

            }

        }

        return res;

    }

}
