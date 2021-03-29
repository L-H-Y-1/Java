package Tree;

/*
    102. 二叉树的层序遍历

        给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

        注:  BFS模板
            level = 0
            while queue 不空：
                size = queue.size()
                while (size --) {
                    cur = queue.pop()
                    for 节点 in cur的所有相邻节点：
                        if 该节点有效且未被访问过：
                            queue.push(该节点)
                }
                level ++;

    解题思路

        1. 若根节点为空,返回空ArrayList
        2. 新建集合res,存放每一层节点值的集合
        3. 新建队列queue,根节点入队

        4. 当队列不空,开始循环

            1. levelNum为队列当前长度,即当前层次内节点个数
            2. 新建集合levelList存放每一层的节点值
            3. 遍历当前队列
                1. 队头出队并赋给node
                2. node的值加入levelList
                3. 如果node左右孩子不空,左右孩子入队
                4. levelNum次循环后,当前层次内节点全部出队,节点的所有孩子全部入队,levelList存放了所有出队节点的值
            4. 如果levelList不空,加入res.当前层次结束,进入下一层次

        5. 返回res集合,集合中存放的第i个集合即为第i层的所有节点值

*/

import java.util.*;

public class B_102 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        List<List<Integer>> lists = levelOrder(root);

        Iterator iterator = lists.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        //若根节点为空,返回空ArrayList
        if (root==null){
            return new ArrayList<>();
        }

        //新建集合res,存放每一层节点值的集合
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        //新建队列queue,根节点入队
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //当队列不空,开始循环
        while ( !queue.isEmpty() ){

            //levelNum为队列当前长度,即当前层次内节点个数
            int levelNum = queue.size();

            //新建集合levelList存放每一层的节点值
            List<Integer> levelList = new ArrayList<>();

            //遍历当前队列
            for (int i = 0; i < levelNum ; i++) {

                //队头出队并赋给node,值加入levelList
                TreeNode node = queue.poll();
                levelList.add(node.val);

                //如果node左右孩子不空,左右孩子入队
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }

            }
            //levelNum次循环后,当前层次内节点全部出队
            //当前层次内节点所有的孩子全部入队,levelList存放了所有出队节点的值

            //如果levelList不空,加入res.当前层次结束,进入下一层次
            if (levelList!=null){
                res.add(levelList);
            }

        }

        //返回res集合,集合中存放的第i个集合即为第i层的所有节点值
        return res;

    }

}
