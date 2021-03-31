package BackTrack;

/*
    90. 子集 II

        给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
        解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

    解题思路

        1. 新建res存放所有路径集合
        2. 新建track集合存放路径
        3. 数组排序
        4. backtrack()方法
            1. 复制路径集合加入res
            2. 遍历数组
            3. 如果元素与上一元素处于同级决策树且重复,跳过,不同级元素重复不跳过
            4. 第i个元素加入路径
            5. 进入下一层决策树(下层决策树遍历从i+1开始)
            6. 删除路径元素,回退

*/

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class C_90 {

    public static void main(String[] args) {

        int[] nums = {1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        Iterator iterator = lists.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }

    }

    //新建res存放所有路径集合
    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        //新建track集合存放路径
        LinkedList<Integer> track = new LinkedList<>();

        //数组排序
        Arrays.sort(nums);

        backtrack(nums,0,track);
        return res;

    }

    public static void backtrack(int[] nums , int start , List<Integer> track){

        //复制路径集合加入res
        res.add(new LinkedList<>(track));

        //遍历数组
        for (int i = start ; i < nums.length; i++) {

            //元素与上一元素处于同级决策树且重复,跳过
            //不同级决策树元素重复不跳过
            if ( i!=start && nums[i]==nums[i-1]){
                continue;
            }

            //元素加入路径
            track.add(nums[i]);

            //进入下一层决策树
            backtrack(nums,i+1,track);

            //删除路径元素,回退
            track.remove(track.size()-1);

        }

    }

}
