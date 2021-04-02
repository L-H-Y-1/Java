package Array;

/*
    面试题 17.21. 直方图的水量

        给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，
        最后直方图能存多少水量?直方图的宽度为 1。

    解题思路

        1. leftMax数组存储当前位置左边最高的柱子
        2. rightMax数组存储当前位置右边最高的柱子
        3. 遍历数组
            1. 比较leftMax和rightMax
            2. 用较小的数值-当前高度=当前位置存水量

*/

public class K_audition_17_21 {
    public static void main(String[] args) {

        int[] height = {2,0,2};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        if (height.length==0){
            return 0;
        }

        //找出当前位置左边最高的柱子
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        System.out.println("当前位置左边最高的柱子");
        System.out.print(leftMax[0]+" ");
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
            System.out.print(leftMax[i]+" ");
        }
        System.out.println(" ");

        //找出当前位置右边最高的柱子
        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        System.out.println("当前位置右边最高的柱子(倒序)");
        System.out.print(rightMax[height.length-1]+" ");
        for (int i = height.length-2; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
            System.out.print(rightMax[i]+" ");
        }
        System.out.println(" ");

        //两边最高柱子中较低的柱子-当前高度=当前位置存水量
        int ans = 0;
        for (int i = 0; i < height.length ; i++) {
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }

        return ans;
    }
}
