package Array;

/*
    380. O(1) 时间插入、删除和获取随机元素

        设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
        insert(val)：当元素 val 不存在时，向集合中插入该项。
        remove(val)：元素 val 存在时，从集合中移除该项。
        getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。

    解题思路

        1. 使用ArrayList储存元素,HashMap储存元素对应下标

        2. insert(val)
            1. 如果元素已经存在,返回false
            2. 若dataList中无此元素,添加元素
            3. 更新dataIndex,返回true

        3. remove(val)
            1. 若元素不存在,返回false
            2. 若元素存在
                1. 取出dataList末尾元素,放入该元素位置,删除末尾元素
                2. 更新dataIndex,返回true

        4. getRandom()
            1. 创建随机数对象
            2. 随机选取dataList下标取出元素


*/

import java.util.*;

public class N_380 {

    // 使用ArrayList储存元素,HashMap储存元素对应下标
    List<Integer> dataList = new ArrayList();
    Map<Integer,Integer> dataIndex = new HashMap<>();
    Random random = new Random();

    /**
     * Initialize your data structure here.
     * */
    public N_380() {
    }

    /**
     * Inserts a value to the set.
     * Returns true if the set did not already contain the specified element.
     * */
    public boolean insert(int val) {
        // 如果元素已经存在,返回false
        if (dataList.contains(val)){
            return false;
        }
        // 若dataList中无此元素,添加元素,更新dataIndex,返回true
        dataList.add(dataList.size(),val);
        dataIndex.put(val,dataList.size());
        return true;
    }

    /**
     * Removes a value from the set.
     * Returns true if the set contained the specified element.
     * */
    public boolean remove(int val) {
        // 若元素不存在,返回false
        if (!dataList.contains(val)){
            return false;
        }
        // 若元素存在,取出dataList末尾元素,放入该元素位置,删除末尾元素
        int lastData = dataList.get(dataList.size()-1);
        int index = dataList.indexOf(val);
        dataList.set(index,lastData);
        dataList.remove(dataList.size()-1);
        // 更新dataIndex,返回true
        dataIndex.put(lastData,index);
        dataIndex.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     * */
    public int getRandom() {
        return dataList.get(random.nextInt(dataList.size()));
    }


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
