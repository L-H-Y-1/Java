package Tree;

/*
    106. 从中序与后序遍历序列构造二叉树

        根据一棵树的中序遍历与后序遍历构造二叉树。
        注意: 你可以假设树中没有重复的元素。

    解题思路

        1. bulidT()方法
            1. 传入中序遍历数组与后序遍历数组,及其起始与结束下标
            2. 根据参数构造二叉树

        2. 调用bulidT(),初始下标参数为0,inorder.length-1和0,postorder.length-1
            1. 递归结束条件起始下标>结束下标
            2. 根节点的值是后序遍历最后一位,new根节点
            3. 搜索根节点在中序遍历中的下标,将左右子树分开
                中序遍历为[inStart,index-1],root,[index+1,inEnd]
            4. 根据节点个数将后序遍历的左右子树分开
                后序遍历左子树节点数=中序遍历左子树节点数=index-inStart
                [postStart,postStart+leftSize-1],[postStart+leftSize,postEnd-1],root
            5. 得到了左右子树的中序遍历和后序遍历,递归调用bulidT()方法分别处理左右子树
            6. 返回根节点

*/

public class N_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildT(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }

    public TreeNode buildT(int[] inorder, int inStart , int inEnd , int[] postorder , int postStart , int postEnd) {

        //递归结束条件
        if (postStart>postEnd){
            return null;
        }

        //根节点的值是后序遍历最后一位
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        //找中序遍历中根节点的位置,将左右子树分开
        //[inStart,index-1],root,[index+1,inEnd]
        int index = 0;
        for (int i = 0; i <= inEnd ; i++) {
            if (rootVal==inorder[i]){
                index = i;
                break;
            }
        }

        //将后序遍历的左右子树分开
        //后序遍历左子树节点数=中序遍历左子树节点数=index-inStart
        //[postStart,postStart+leftSize-1],[postStart+leftSize,postEnd-1],root
        int leftSize = index-inStart;

        //分别递归调用函数处理左右子树
        root.left = buildT(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        root.right = buildT(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);

        return root;

    }

}
