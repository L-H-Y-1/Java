package Array;

/*
 * 350. 两个数组的交集 II
 *
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。可以不考虑输出结果的顺序。

 * 解题思路

    1 不排序

        1. 比较两个数组的长短
        2. 遍历短数组，存入map。
            key为数组元素，value为出现次数
            令count为对应元素的value，count为0，存入元素和1,count不为0，重新存入元素和count++
        3. 初始化结果数组，长度为短数组的长度
        4. 遍历长数组，重复元素存入结果数组
            令count为对应元素的value，count为0，元素没有重复,
            count不为0，元素存入结果数组，count--
            自减后count不为0，将元素和count重新存入map，否则删除元素

    2 排序双指针

        1. 数组排序
        2. 初始化三个指针，结果数组长度为短数组长度  Math.min()
        3. 比较两个数组指针指向的元素，相等则将元素放入结果数组，三个指针都++
            不相等将较小元素的指针++，循环比较
            直到任一数组结束
        4. 可以使用其中一个数组作为结果数组节省内存？

*/

import java.util.*;

public class A_350 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {9,4,9,8,4};
        int[] nums2 = {4,5,9};
        int[] printNum = Arrays.copyOf(solution.intersect(nums1,nums2),solution.intersect(nums1,nums2).length);

        System.out.print("[ ");
        for (int i = 0; i < printNum.length; i++) {
            System.out.print(printNum[i]+" ");
        }
        System.out.println("]");
    }
}

class Solution {

    public Solution() {
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        //1    两层for循环，逐个对比(不能计算次数) ×

        /*
        int[] printNum = new int[10];
        int k = 0;

        a:  for (int i = 0; i < nums1.length; i++) {
            b:  for (int j = 0; j < nums2.length; j++) {
                if ( nums1[i] == nums2[j]){
                    printNum[k++] = nums1[i];
                    continue a;
                }
            }

        return printNum;
        }*/

        //2    使用HashMap

        /*
        //将短数组存入map
        if (nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }

        Map<Integer,Integer> map = new HashMap<>();
        for ( int num : nums1 ) {
            int count = map.getOrDefault(num,0);
            map.put(num,++count);
        }

        *//*Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        for ( Map.Entry<Integer,Integer> node : entrySet ) {
            System.out.println(node.getKey()+"+"+node.getValue());
        }*//*

        //长数组与map比较，count>0则放入结果数组中，同时count--
        // --后count=0就删除元素
        int[] intersectArray = new int[nums1.length];
        int k = 0;

        for ( int num : nums2 ) {
            int count = map.getOrDefault(num,0);
            if (count>0){
                intersectArray[k++] = num;
                count--;
                if (count>0){
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }

        }

        return Arrays.copyOfRange(intersectArray,0,k);
        */

        //3 排序双指针

        //排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0 , index2 = 0 ,k = 0;
        int[] intersectArray = new int[Math.min(nums1.length,nums2.length)];

        //比较
        while( index1<nums1.length && index2<nums2.length){

            if (nums1[index1] == nums2[index2]){
                intersectArray[k++] = nums1[index1];
                index1++;
                index2++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }else{
                index1++;
            }

        }

        return Arrays.copyOfRange(intersectArray,0,k);
    }
}
