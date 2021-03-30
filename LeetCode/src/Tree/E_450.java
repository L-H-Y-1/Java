package Tree;

/*
    450. 删除二叉搜索树中的节点

        给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
        并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
        一般来说，删除节点可分为两个步骤：
            首先找到需要删除的节点；
            如果找到了，删除它。
        说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

    解题思路

        1. 根节点为空,返回null
        2. 若key>root.val,删除节点在右子树,用root右孩子和key递归
        3. 若key<root.val,删除节点在左子树,用root若孩子和key递归
        4. 若key=root.val,当前节点即删除节点
            1. 节点为叶子,直接删除
            2. 节点有右子树,找到"后继",令节点值为"后继"值,删除"后继"
            3. 节点只有左子树,找到"前驱",令节点值为"前驱"值,删除"前驱"

*/

public class E_450 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7));
        int val = 1 ;
        System.out.println(deleteNode(root,val));

    }

    public static TreeNode deleteNode(TreeNode root, int key) {

        //根节点为空,返回null
        if (root==null){
            return null;
        }

        //若key>root.val,删除节点在右子树,用root右孩子和key递归
        //若key<root.val,删除节点在左子树,用root若孩子和key递归
        if (key>root.val){
            root.right = deleteNode(root.right,key);
        }else if (key<root.val){
            root.left = deleteNode(root.left,key);
        }else {

            //若key=root.val,当前节点即删除节点
            //节点为叶子,直接删除
            //节点有右子树,找到"后继",令节点值为"后继"值,删除"后继"
            //节点只有左子树,找到"前驱",令节点值为"前驱"值,删除"前驱"
            if (root.left==null && root.right==null){
                root = null;
            }else if (root.right!=null){
                root.val = successor(root);
                root.right = deleteNode(root.right,root.val);
            }else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left ,root.val);
            }

        }


        return root;

    }

    //找到比节点值大的最小节点("后继")
    public static int successor(TreeNode root){
        root = root.right;
        while (root.left!=null){
            root = root.left;
        }
        return root.val;
    }

    //找到比节点值小的最大节点("前驱")
    public static int predecessor(TreeNode root){
        root = root.left;
        while (root.right!=null){
            root = root.right;
        }
        return root.val;
    }

}
