package Tree;

/*
    700. 二叉搜索树中的搜索

        给定二叉搜索树（BST）的根节点和一个值。
        你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。
        如果节点不存在，则返回 NULL。

    解题思路

        1. 递归

            1. 节点为空或者节点值等于val,返回节点
            2. 若节点不空且值不等于val
                1. val大于节点值,递归调用方法,参数为节点右孩子
                2. val小于节点值,递归调用方法,参数为节点左孩子
            3. 返回调用结果

        2. 迭代

            1. 若节点不空且值不等于val
                1. val大于节点值,节点等于节点右孩子
                2. val小于节点值,节点等于节点左孩子
                3. 知道节点为空或节点值等于val,退出循环
            2. 返回节点

*/

public class D_700 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7));
        int val = 5 ;
        TreeNode node = searchBST(root,val);
        System.out.println(node);
    }

    public static TreeNode searchBST(TreeNode root, int val) {

        // 1 递归
        /*if (root==null || val==root.val){
            return root;
        }

        return val>root.val ? searchBST(root.right, val) : searchBST(root.left, val) ;
        */

        // 2 迭代

        while (root!=null && val!=root.val){
            root = val>root.val ? root.right : root.left ;
        }
        return root;

    }

}
