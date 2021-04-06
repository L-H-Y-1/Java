package Tree;

import java.util.*;

/*
    341. 扁平化嵌套列表迭代器

        给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
        列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。

    解题思路

        1. 新建栈stack

        2. 构造函数
            1. 将所有NestedInteger元素逆序放入栈中

        . next()方法
            1. 调用hasNext()判断元素是否是int
            2. 是就返回int并删除元素
            3. 不是就返回-1

        4. hasNext()方法
            1. 栈空返回false
            2. 栈不空
                1. 取栈顶元素(不删除元素,next()会删除int类型的元素)
                2. 判断是否为int
                    1. 是int,返回true
                    2. 是list
                        1. 取栈顶元素(并删除元素)
                        2. 将list逆序存入栈中
                        3. 递归调用hasNext()

*/

public class T_341 {
}

class NestedIterator implements Iterator<Integer> {

    //新建栈stack
    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {

        //构造函数中将所有NestedInteger逆序放入栈中
        for (int i = nestedList.size()-1 ; i >=0 ; i--) {
            stack.addLast(nestedList.get(i));
        }

    }

    @Override
    public Integer next() {

        //调用hasNext()判断元素是否是int,是就返回int并删除元素,不是就返回-1
        return hasNext() ? stack.pollLast().getInteger() : -1 ;

    }

    @Override
    public boolean hasNext() {

        if (stack.isEmpty()){
            return false;
        }else {
            //取栈顶元素(不删除元素,next()会删除int类型的元素)
            NestedInteger item = stack.peekLast();
            //判断是否为int
            if (item.isInteger()){
                //是int,返回true
                return true;
            }else {
                //是list,取栈顶元素(并删除元素)
                item = stack.pollLast();
                //将list逆序存入栈中
                List<NestedInteger> list = item.getList();
                for (int i = list.size()-1 ; i >=0 ; i--) {
                    stack.addLast(list.get(i));
                }
                //递归调用hasNext()
                return hasNext();
            }

        }
    }

}

interface NestedInteger {

         // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();

         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return empty list if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
}