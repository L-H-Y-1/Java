package Tree;

/*
    222. 完全二叉树的节点个数

    给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
    完全二叉树 的定义如下:
        在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
        并且最下面一层的节点都集中在该层最左边的若干位置。
        若最底层为第 h 层，则该层包含 1~ 2^h 个节点。
    满二叉树节点数为2^n-1 (n为层高)

    解题思路

        1. 将完全二叉树分割成满二叉树和完全二叉树
        2. 计算根节点的左右子树高度,如果高度相等,即左子树满,左子树加上根节点共2^n个节点(n为左子树高度)
        3. 如果高度不等,即右子树为满二叉树,右子树加上根节点共2^n个节点(n为右子树高度)
        4. 递归计算另一二叉树的节点数
        注:  计算乘方 x^y
            double num = Math.pow(x,y)

*/

public class G_222 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),null));
        System.out.println(countNodes(root));

    }

    public static int countNodes(TreeNode root) {

        if (root==null){
            return 0;
        }

        //计算根节点的左右子树高度
        int leftHeight = treeHeight(root.left);
        System.out.println("leftHeight="+leftHeight);
        int rightHeight  = treeHeight(root.right);
        System.out.println("rightHeight="+rightHeight);

        //如果高度相等,即左子树满,左子树加上根节点共2^n个节点(n为左子树高度)
        //如果高度不等,即右子树为满二叉树,右子树加上根节点共2^n个节点(n为右子树高度)
        //递归计算另一二叉树的节点数
        if (leftHeight==rightHeight){
            return (int) (countNodes(root.right) + Math.pow(2,leftHeight));
        }else {
            return (int) (countNodes(root.left) + Math.pow(2,rightHeight));
        }

    }


    public static int treeHeight(TreeNode root) {

        return root==null ? 0 : treeHeight(root.left)+1 ;

    }

}
