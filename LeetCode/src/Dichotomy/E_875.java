package Dichotomy;

/*
    875. 爱吃香蕉的珂珂

        珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。
        警卫已经离开了，将在 H 小时后回来。
        珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。
        每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，
        她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
        珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
        返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。

    解题思路

        1. 将数组升序排序,最大堆即为最后一个元素
        2. 初始解空间为[1,max]即,速度范围是每小时吃一根香蕉~每小时吃一堆香蕉(最大堆)
        3. 解空间为空时结束循环
            1. speed = left + (right-left)/2;
            2. 调用canFinish()方法判断速度为speed能否吃完
                1. 如果速度为speed时可以吃完,解空间变为[left,speed -1]
                    因为寻找左侧边界,所以要继续在此数值左侧找
                    若左边没有答案,left,right和speed会逐渐右移直至三者均指向此数值前一位
                    前一位不是答案,left = speed+1,left回到此数值,同时left=right+1,结束循环
                2. 速度为speed时吃不完,解空间变为[speed+1,max]
        4. 返回左侧边界left


*/

import java.util.Arrays;

public class E_875 {

    public int minEatingSpeed(int[] piles, int h) {

        //将数组升序排序,最大堆即为最后一个元素
        Arrays.sort(piles);

        //初始解空间为[1,max]
        //即,每小时吃一根香蕉~一堆香蕉(最大堆)
        int max = piles[piles.length-1];
        int left = 1, right = max;

        //解空间为空时结束循环
        while (left<=right){

            int speed = left + (right-left)/2;

            if (canFinish(piles,speed,h)){
                //如果速度为speed时可以吃完,解空间变为[left,speed -1]
                //因为寻找左侧边界,所以要继续在此数值左侧找
                //若左边没有答案,left,right和speed会逐渐右移直至三者均指向此数值前一位
                //前一位不是答案,left = speed+1,left回到此数值,同时left=right+1,结束循环
                right = speed -1;
            }else {
                //速度为speed时吃不完,解空间变为[speed+1,max]
                left = speed+1;
            }

        }

        return left;

    }

    /**
     * 如果速度为speed,在h小时内能否吃完所有香蕉
     * */
    public boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for ( int num : piles  ) {
            time += timeOf(num,speed);
        }
        return time<=h;
    }

    /**
     * 一堆香蕉有num个,速度为speed,返回吃完所需时间
     * */
    public int timeOf(int num, int speed) {
        return (num/speed) + ( (num%speed>0) ? 1 : 0 ) ;
    }

}
