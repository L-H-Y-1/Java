package JZ;


/*
*   剑指 Offer 28. 对称的二叉树
*       请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
*
*   解题思路

        #### isSymmetric()
            1. 若树空，返回true
            2. 树不空，调用help()向下判断节点左右孩子是否对称

        #### help()
            1. 若两节点都为空，对称
            2. 若某一节点为空，或者两节点值不相等，不对称
            3. 递归判断root1的左孩子和root2的右孩子是否对称
                再递归判断root1的右孩子和root2的左孩子是否对称
                要求两者均对称

* */
public class JZ28 {

    public boolean isSymmetric(TreeNode root) {
        // 若树空，返回true。树不空，调用help()向下判断节点左右孩子是否对称
        return root==null ? true : help(root.left,root.right);
    }

    // 判断两节点及其左右孩子是否对称
    public static boolean help(TreeNode root1,TreeNode root2){

        // 若两节点都为空，对称
        if (root1==null && root2==null){
            return true;
        }

        // 若某一节点为空，或者两节点值不相等，不对称
        if (root1==null || root2==null || root1.val!=root2.val){
            return false;
        }

        // 递归判断root1的左孩子和root2的右孩子是否对称
        // 再递归判断root1的右孩子和root2的左孩子是否对称
        // 要求两者均对称
        return help(root1.left,root2.right) && help(root1.right,root2.left);

    }

}
