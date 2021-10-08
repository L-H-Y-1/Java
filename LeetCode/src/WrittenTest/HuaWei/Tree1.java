package WrittenTest.HuaWei;

/*
    最佳节点 75%
        二叉树，每个节点含一个编号和一个值，该值可能为负，
        找出最优节点（除根节点外），使得在该节点将树分成两棵树后
        （原先的树移除节点及子节点，新树以该节点为根节点）
        两棵树各节点的和之间的差绝对值最大
        输出节点编号。如有相同的，输出编号最小的节点
4
4 9 -7 -8
0 1
0 3
1 2

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree1 {
// public class Main {
public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    // 节点个数
    int nodeNum = cin.nextInt();
    String s = cin.nextLine();
    // 列表储存节点，保存节点编号和值
    List<TreeNode> treeNodes = new ArrayList<>();
    for (int i = 0; i < nodeNum; i++) {
        int val = cin.nextInt();
        TreeNode node = new TreeNode(i,val);
        treeNodes.add(i,node);
        //System.out.println(i+","+treeNodes.get(i).val);
    }
    // 建立节点之间的父子关系
    while (cin.hasNextInt()){
        int fatherNo = cin.nextInt();
        int sonNo = cin.nextInt();
        TreeNode father = treeNodes.get(fatherNo);
        TreeNode son = treeNodes.get(sonNo);
        if (father.left==null){
            father.left = son;
        }else {
            father.right = son;
        }
        //System.out.println(fatherNo+","+sonNo);
        String st = cin.nextLine();

    }
    root = treeNodes.get(0);
    for (int i = 0; i < nodeNum; i++) {
        resList.add(i,0);
    }
    //System.out.println(root.no+","+root.val);
    findBestNode(root);
    int maxNum = 0;
    int maxNo = 0;
    for (int i = 1; i < resList.size(); i++) {
        if(resList.get(i)>maxNum){
            maxNum = resList.get(i);
            maxNo = i;
        }
    }
    System.out.println(maxNo);

}

    // 列表下标为分裂节点下标，值为两棵树的节点和之差绝对值
    public static List<Integer> resList = new ArrayList<>();
    public static TreeNode root;

    public static void findBestNode(TreeNode node) {

        if (node==null){
            return;
        }
        //System.out.println("find"+node.no);
        if (node.left!=null){
            helpFind(node,node.left);
            findBestNode(node.left);
        }
        if (node.right!=null){
            helpFind(node,node.right);
            findBestNode(node.right);
        }

    }

    public static void helpFind(TreeNode father,TreeNode spiltNode) {
        // 断开父子关系
        //System.out.println("help"+spiltNode.no);
        boolean flag = false;
        if (father.left==spiltNode){
            father.left = null;
            flag = true;
        }else {
            father.right = null;
            flag = false;
        }
        // 计算两棵树的节点和之差绝对值
        int num1 = nodeSum(root);
        int num2 = nodeSum(spiltNode);
        int res = Math.abs(num1-num2);
        resList.add(spiltNode.no,res);
        // 恢复父子关系
        if (flag){
            father.left=spiltNode;
        }else {
            father.right = spiltNode;
        }
    }

    // 给定根节点，求树各节点值的和
    public static int nodeSum(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftVal = nodeSum(root.left);
        int rightVal = nodeSum(root.right);
        return leftVal+rightVal+root.val;
    }
}
class TreeNode{
    int no;
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int no, int val) {
        this.no = no;
        this.val = val;
    }

    public TreeNode(int val) {
        this.val = val;
    }

}
