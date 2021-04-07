package Tree;

/*
    236. 二叉树的最近公共祖先

        给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
        最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
        （一个节点也可以是它自己的祖先）。”

    解题思路

        二叉树都是遍历问题,前序中序还是后序,本题是后序遍历
        问题:函数的作用?参数变量是什么?得到递归结果要做什么?

        1 函数的作用
            输入三个参数root，p，q，它会返回一个节点
            1. 如果p,q都在以root为根的树中,返回两者最近公共祖先节点
            2. 都不在,返回null
            3. 只有一个在,返回本身
        2. 参数变量是什么
            函数参数中的变量是root
            lowestCommonAncestor(root)会递归调用root.left和root.right
            求p和q公共祖先,p和q肯定不会变化
        3. 得到递归结果要做什么
            1. base case : root空,返回null. root是p或q,返回root
            2. 最终递归调用方法的结果:
                1. p,q都在以root为根的树中,那么left和right一定分别是p和q
                2. 都不在,返回null
                3. 只有一个在,返回本身
*/

public class O_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {



        //base case
        if (root==null){
            return null;
        }
        if (root==p || root==q){
            return root;
        }

        //后序遍历先递归
        //left为左子树中最近公共祖先节点,right为右子树中最近公共祖先节点
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //操作
        //p,q都在以root为根的树中,那么left和right一定分别是p和q
        if (left!=null && right!=null){
            return root;
        }
        //都不在,返回null
        if (left==null && right==null){
            return null;
        }
        //只有一个在,返回本身
        return left==null ? right : left ;

    }
}
