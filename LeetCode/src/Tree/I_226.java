package Tree;

/*
    226. 翻转二叉树

    解题思路

        1. root为null,返回root
        2. 交换左右孩子
        3. 分别调用递归方法,令左右孩子翻转
        4. 返回root

*/

public class I_226 {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {

        //root为null,返回root
        if ( root==null ){
            return root;
        }

        //交换左右孩子
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //分别调用递归方法,令左右孩子翻转
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;

    }
}
