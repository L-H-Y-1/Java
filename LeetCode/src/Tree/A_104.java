package Tree;

/*
    104. 二叉树的最大深度

        给定一个二叉树，找出其最大深度。
        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

    解题思路

        1. root为空,返回0
        2. root不空,返回左右子树深度较大值+1

*/

public class A_104 {
    public static void main(String[] args) {

        //TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode root = null;
        System.out.println(maxDepth(root));
    }



    public static int maxDepth(TreeNode root) {

        return root==null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1 ;

    }

}

class TreeNode {

   int val;
   TreeNode left;
   TreeNode right;

   TreeNode() {}
   TreeNode(int val) {
       this.val = val;
   }

   TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }

}
