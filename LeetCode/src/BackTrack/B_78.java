package BackTrack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
    78. 子集

        给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

    解题思路

        1. 建立res存放所有路径集合
        2. 新建track集合存放路径
        3. backtrack()方法
            1. 复制路径集合加入res
            2. 遍历数组
            3. 如果第i个元素已在路径中,跳过
            4. 第i个元素加入路径
            5. 进入下一层决策树(下层决策树遍历从i+1开始)
            6. 删除路径元素,回退

        注:
            全排列要求路径包含所有元素才能加入集合,子集每下一层都要把路径加入集合
            排列每一层决策树遍历都从0开始 , 组合下层决策树遍历从i+1开始

*/

public class B_78 {
    public static void main(String[] args) {

        int[] nums = {0,1};
        List<List<Integer>> lists = subsets(nums);
        Iterator iterator = lists.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }

    }

    //建立res存放所有路径集合
    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> subsets(int[] nums) {

        //新建track集合存放路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,0,track);
        return res;

    }

    public static void backtrack(int[] nums , int start , List<Integer> track){

        //复制路径集合加入res
        res.add(new LinkedList<>(track));

        //遍历数组
        for (int i = start ; i < nums.length; i++) {

            //元素已在路径中,跳过
            if (track.contains(nums[i])){
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
