package JZ;

/*
    剑指 Offer 27. 二叉树的镜像

    解题思路

        1. 若节点为空，直接返回节点
        2. 递归调用方法处理左右孩子
        3. 交换左右孩子

*/

public class JZ27 {

    public TreeNode mirrorTree(TreeNode root) {

        // 若节点为空，直接返回节点
        if ( root==null ){
            return root;
        }

        //  递归调用方法处理左右孩子
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        // 交换左右孩子
        root.left = right;
        root.right = left;

        return root;

    }

}
