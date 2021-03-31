package BackTrack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
    46. 全排列

        给定一个 没有重复 数字的序列，返回其所有可能的全排列。

    解题思路

        #### 1. 建立res存放所有路径集合

        #### 2. permute()方法
                    1. 新建track集合存放路径
                    2. 调用backtrack()
                    3. 返回res

        #### 3. backtrack()方法

                    1. 如果路径包含了数组所有元素,复制路径集合加入res,当前路径结束
                    2. 遍历数组
                        1. 元素已在路径中,跳过
                        2. 元素加入路径
                        3. 进入下一层决策树
                        4. 删除路径元素,回退

*/

public class A_46 {

    public static void main(String[] args) {

        int[] nums = {0,1};
        List<List<Integer>> lists = permute(nums);
        Iterator iterator = lists.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }

    }

    //建立res存放所有路径集合
    public static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {

        //新建track集合存放路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;

    }

    public static void backtrack(int[] nums , List<Integer> track){

        //如果路径包含了数组所有元素,复制路径集合加入res,当前路径结束
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        //遍历数组
        for (int i = 0; i < nums.length; i++) {

            //元素已在路径中,跳过
            if (track.contains(nums[i])){
                continue;
            }

            //元素加入路径
            track.add(nums[i]);

            //进入下一层决策树
            backtrack(nums,track);

            //删除路径元素,回退
            track.remove(track.size()-1);

        }

    }

}
