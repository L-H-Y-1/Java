package Tree;

/*
    814. 二叉树剪枝

        给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
        返回移除了所有不包含 1 的子树的原二叉树。
        ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)

    解题思路

        1. 节点为空,返回null
        2. 递归处理节点的左右孩子
        3. 如果节点为叶子且值为0,删除节点
        4. 返回节点

*/

public class H_814 {
    public static void main(String[] args) {

    }

    public static TreeNode pruneTree(TreeNode root) {

        if (root==null){
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.right==null && root.left==null && root.val==0){
            root = null;
        }

        return root;

    }

}
