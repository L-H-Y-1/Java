package Dichotomy;

/*
    1011. 在 D 天内送达包裹的能力

        传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
        传送带上的第 i 个包裹的重量为 weights[i]。
        每一天，我们都会按给出重量的顺序往传送带上装载包裹。
        我们装载的重量不会超过船的最大运载重量。
        返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。

    解题思路

        shipWithinDays()方法

            1. 初始解空间为[1,sum],即每天可运送重量范围是1~所有包裹重量
            2. 解空间为空时结束循环
                1. mid = left + (right-left)/2
                2. 调用canDeliver()方法判断D天内能否运完
                    1. 如果每天运送重量为mid,D天内可以运完,解空间变为[left,mid-1],继续搜索左侧边界
                    2. 如果每天运送重量为mid,D天内不能运完,解空间变为[mid + 1,right]
            3. 返回left

        canDeliver()方法
            1. 初始化指针指向第一个包裹
            2. 从第一天开始遍历到第d天
                1. 每一天的可运送量count初始为num
                2. 循环
                    1. 若count>当前包裹重量,当前包裹可运送
                    2. 可运送量count-当前包裹重量,指针后移,继续判断下一个包裹能否运送
                    3. 若包裹运送完毕且没有退出循环(没超过d天),返回true,即d天内能运完
                    4. 当count<当前包裹重量,即当天不能再运送其他包裹,退出循环
                3. 循环结束,当天可运送包裹已计算完成,进入下一天
            3. 若遍历结束,即到第d天包裹扔未运送完毕,返回false,即d天内不能运完

*/

public class F_1011 {

    public static void main(String[] args) {
        F_1011 f_1011 = new F_1011();
        int[] weights = {1,2,3,1,1};
        int d = 4;
        int num = 3;
        System.out.println(f_1011.canDeliver(weights,d,num));
    }

    public int shipWithinDays(int[] weights, int D) {

        //初始解空间为[1,sum],即每天可运送重量范围是1~所有包裹重量
        int left = 1, right = getSum(weights);

        //解空间为空时结束循环
        while (left<=right){

            int mid = left + (right-left)/2 ;

            if (canDeliver(weights,D,mid)){
                //如果每天运送重量为mid,D天内可以运完
                //解空间变为[left,mid-1],继续搜索左侧边界
                right = mid - 1;
            }else {
                //如果每天运送重量为mid,D天内不能运完
                //解空间变为[mid + 1,right]
                left = mid + 1;
            }
        }

        return left;

    }

    /**
     * 每天运送重量为num,D天内能否运完
     * */
    public boolean canDeliver(int[] weights, int d, int num) {

        //初始化指针指向第一个包裹
        int index = 0;

        //从第一天开始遍历到第d天
        for (int day = 1; day <= d ; day++) {

            //每一天的可运送量count初始为num
            int count = num;

            while ( (count -= weights[index])>=0 ){

                //若count>当前包裹重量,当前包裹可运送
                //可运送量count-当前包裹重量
                //指针后移,继续判断下一个包裹能否运送
                index++;

                //若包裹运送完毕且没有退出循环(没超过d天),返回true,即d天内能运完
                if (index==weights.length){
                    return true;
                }
            }

        }

        //若遍历结束,即到第d天仍有包裹未运送,返回false,即d天内不能运完
        return false;

    }

    /**
     * 返回数组中元素的和
     * */
    public int getSum(int[] weights) {
        int sum = 0;
        for ( int num : weights     ) {
            sum += num;
        }
        return sum;
    }

}
