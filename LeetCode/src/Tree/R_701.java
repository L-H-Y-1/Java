package Tree;

/*
    701. 二叉搜索树中的插入操作

        给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
        返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
        注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。
        你可以返回 任意有效的结果 。

    解题思路

        1. 节点为空,新建值为val的节点,返回
        2. val>节点值,递归处理节点右孩子
        3. val<节点值,递归处理节点左孩子

*/

public class R_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root==null){
            return new TreeNode(val);
        }

        if (val>root.val){
            root.right = insertIntoBST(root.right,val);
        }else {
            root.left = insertIntoBST(root.left,val);
        }

        return root;

    }

}
