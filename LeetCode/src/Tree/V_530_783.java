package Tree;

/*
    783. 二叉搜索树节点最小距离
        给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

    530. 二叉搜索树的最小绝对差
        给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

    解题思路

    1. 二叉搜索树中序遍历后,其值是升序的,因此最小距离一定是某两个相邻元素的差
    2. 调用BST()方法中序遍历二叉搜索树,将其转化为一个升序list
    3. 遍历list,选出相邻元素的差中最小的

*/

import java.util.ArrayList;
import java.util.List;

public class V_530_783 {

    public int minDiffInBST(TreeNode root) {

        //将二叉搜索树转化为升序list
        BST(root);

        //遍历list,最小距离一定是相邻元素差
        int minDiff = 100000;
        int diff = 100000;
        for (int i = 1; i < list.size() ; i++) {
            diff = list.get(i) - list.get(i-1);
            if (diff<minDiff){
                minDiff = diff;
            }
        }

        return minDiff;

    }

    public List<Integer> list = new ArrayList<>();

    public void BST(TreeNode root){

        //递归结束条件
        if (root==null){
            return ;
        }

        BST(root.left);

        //中序遍历,将二叉搜索树转化为升序list
       list.add(root.val);

        BST(root.right);

    }


}
