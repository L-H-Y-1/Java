package Tree;

/*
    98. 验证二叉搜索树

        给定一个二叉树，判断其是否是一个有效的二叉搜索树。
        假设一个二叉搜索树具有如下特征：
            节点的左子树只包含小于当前节点的数。
            节点的右子树只包含大于当前节点的数。
            所有左子树和右子树自身必须也是二叉搜索树。

    解题思路

        isValidBST(TreeNode root)方法

            1. 根节点为空,返回true
            2. 返回调用isBST的结果,初始参数是root，最大long值,最小long值

        isBST(TreeNode root , long max , long min)方法

            1. 节点为空,返回true
            2. 若节点值不在(min,max)开区间内,返回false
            3. 对节点左右孩子进行递归调用isBST()方法
            4. 更新左孩子上限和右孩子下限为节点值
            5. 两次判断结果相与为返回值

*/

public class C_98 {
    public static void main(String[] args) {

        //TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode root = new TreeNode(1,new TreeNode(1),null);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {

        if (root==null){
            return true;
        }

        return isBST(root,Long.MAX_VALUE,Long.MIN_VALUE);

    }

    public static boolean isBST( TreeNode root , long max , long min ){

        if (root==null){
            return true;
        }

        if (root.val>=max || root.val<=min){
            return false;
        }

        return isBST(root.left,root.val,min)&&isBST(root.right,max,root.val);

    }

}
