package Tree;

/*
    114. 二叉树展开为链表

        给你二叉树的根结点 root ，请你将它展开为一个单链表：
        展开后的单链表应该同样使用 TreeNode ，
        其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
        展开后的单链表应该与二叉树 先序遍历 顺序相同。

    解题思路

        1. 节点为空,结束
        2. 递归处理节点的左右子树
        3. 保存左右子树
        4. 新左子树置空,原左子树成为新右子树
        5. 原右子树接到新右子树末端

*/

public class K_114 {
    public static void main(String[] args) {

    }

    public static void flatten(TreeNode root) {

        if (root==null){
            return;
        }

        //递归处理节点的左右子树
        flatten(root.left);
        flatten(root.right);

        //保存左右子树
        TreeNode left = root.left;
        TreeNode right = root.right;

        //新左子树置空,原左子树成为新右子树
        root.left = null;
        root.right = left;

        //原右子树接到新右子树末端
        TreeNode cur = root;
        while (cur.right!=null){
            cur = cur.right;
        }
        cur.right = right;

    }


}
