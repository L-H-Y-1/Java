package Tree;

/*
    105. 从前序与中序遍历序列构造二叉树

        根据一棵树的前序遍历与中序遍历构造二叉树。
        注意: 你可以假设树中没有重复的元素。

    解题思路

        1. bulidBinaryTree()方法
            1. 传入前序遍历数组与中序遍历数组,及其起始与结束下标
            2. 根据参数构造二叉树

        2. 调用bulidBinaryTree(),初始下标参数为0,preorder.length-1和0,inorder.length-1
            1. 递归结束条件起始下标>结束下标
            2. 根节点的值是前序遍历数组第一个元素,new根节点
            3. 搜索根节点在中序遍历中的下标,将左右子树分开
                中序遍历为[inStart,inRootIndex-1],root,[inRootIndex+1,inEnd]
            4. 根据节点个数将前序遍历左右子树分开
                前序遍历左子树节点个数=中序遍历左子树节点个数=inRootIndex-inStart
                前序遍历为root,[preStart+1,preStart+leftSize],[preStart+leftSize+1,preEnd]
            5. 得到了左右子树的前序遍历和中序遍历,递归调用bulidBinaryTree()方法分别处理左右子树
            6. 返回根节点

*/

public class M_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return bulidBinaryTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    public TreeNode bulidBinaryTree(int[] preorder, int preStart , int preEnd , int[] inorder , int inStart , int inEnd ){

        //递归结束条件
        if (preStart>preEnd){
            return null;
        }

        //根节点是前序遍历第一个元素
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        //搜索根节点在中序遍历中的下标,将左右子树分开
        //[inStart,inRootIndex-1],root,[inRootIndex+1,inEnd]
        int inRootIndex = 0;
        for (int i = inStart; i <= inEnd ; i++) {
            if (rootVal==inorder[i]){
                inRootIndex = i;
                break;
            }
        }

        //前序遍历左子树节点个数=中序遍历左子树节点个数=inRootIndex-inStart
        //根据节点个数将前序遍历左右子树分开
        //root,[preStart+1,preStart+leftSize],[preStart+leftSize+1,preEnd]
        int leftSize = inRootIndex - inStart;

        //得到了左右子树的前序遍历和中序遍历
        //递归调用bulidBinaryTree()方法分别处理左右子树
        root.left = bulidBinaryTree(preorder,preStart+1,preStart+leftSize,inorder,inStart,inRootIndex-1);
        root.right = bulidBinaryTree(preorder,preStart+leftSize+1,preEnd,inorder,inRootIndex+1,inEnd);

        return root;

    }

}
