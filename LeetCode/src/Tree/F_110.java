package Tree;

/*
    110. 平衡二叉树

        给定一个二叉树，判断它是否是高度平衡的二叉树。
        本题中，一棵高度平衡二叉树定义为：
            一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

    解题思路

        1. 节点为空,返回true
        2. 节点不空
            1. 令num为节点左右子树深度差
            2. 如果num绝对值小于1,且左右子树均是BT,返回true
            3. 否则返回false

        注: 求树的深度
            1. 节点为空,返回0
            2. 节点不空,取左右子树深度较大的数值,+1返回

*/

public class F_110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {

        if (root==null){
            return true;
        }

        int num = maxDepth(root.left)-maxDepth(root.right);
        return Math.abs(num)<=1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public static int maxDepth(TreeNode root) {

        return root==null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1 ;

    }

}
