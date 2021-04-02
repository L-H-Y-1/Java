package Tree;

/*
    654. 最大二叉树

        给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
            二叉树的根是数组 nums 中的最大元素。
            左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
            右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
            返回有给定数组 nums 构建的 最大二叉树 。

    解题思路

        1. 构建方法buildMaximumBinaryTree()
        2. 参数为数组,左右指针
        3. 初始左右指针为数组头尾下标
        4. 调用方法
            1. 如果左指针大于右指针,返回null(若左右指针相等,仍有一个元素等待处理)
            2. 找数组中的最大值
            3. 令最大值为根节点
            4. 递归左右数组
            5. 返回根节点

*/

public class L_654 {
    public static void main(String[] args) {

        int[] nums = {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        return buildMaximumBinaryTree(nums,0,nums.length-1);

    }

    public static TreeNode buildMaximumBinaryTree(int[] nums,int left,int right){

        if (left>right){
            return null;
        }

        //找数组中的最大值
        int index = left;
        for (int i = left+1 ; i <= right ; i++) {
            if (nums[index]<nums[i]){
                index = i;
            }
        }

        //令最大值为根节点
        TreeNode root = new TreeNode(nums[index]);

        //递归左右数组
        root.left = buildMaximumBinaryTree(nums,left,index-1);
        root.right = buildMaximumBinaryTree(nums,index+1,right);

        return root;
    }

}
