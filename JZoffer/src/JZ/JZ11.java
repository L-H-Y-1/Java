package JZ;

/*
    剑指 Offer 11. 旋转数组的最小数字

        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
        例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1

    解题思路

        1. 特殊情况
            1. 若数组为空,返回-1,
            2. 数组只有一个元素,返回该元素
            3. 数组首<尾,即数组递增未旋转,返回数组首

        2. 初始解空间为[0,numbers.length-1]

        3. 循环
            1. mid = (left + right)/2
                将数组分为a,b两部分,b->a为非递减顺序
            2. numbers[mid]>numbers[right]
                即numbers[mid]位于a中
                numbers[mid]及左侧不是最小值
                解空间变为[mid,right]
            3. numbers[mid]<numbers[right]
                即numbers[mid]位于b中
                最小值应为numbers[mid]或其右侧数值
               解空间变为[left,mid]
            4. numbers[mid]==numbers[right]
                由于重复元素的存在，无法确认numbers[mid]位置
                除去b尾
            5. left=right时,mid=right,right--,可继续循环
                故结束条件为left>right

        4. 循环结束,返回numbers[left]或numbers[mid]

*/

public class JZ11 {

    public static void main(String[] args) {
        JZ11 jz11 = new JZ11();
        int[] array = new int[]{10,1,10,10,10};
        int res = jz11.minArray(array);
        System.out.println(res);
    }

    public int minArray(int[] numbers) {

        // base case
        if (numbers.length==0 ||numbers==null){
            return -1;
        }
        if (numbers.length==1){
            return numbers[0];
        }
        if (numbers[0]<numbers[numbers.length-1]){
            return numbers[0];
        }

        // 二分查找
        // 初始解空间为[0,numbers.length-1]
        int left = 0, right = numbers.length-1;
        int mid = 0 ;

        while (left<=right){

            mid = (left + right)/2;

            if (numbers[mid]>numbers[right] ){
                // 即numbers[mid]位于a中
                // numbers[mid]及左侧必然不是最小值
                // 解空间变为[mid,right]
                left = mid+1 ;
            }else if (numbers[mid]<numbers[right]){
                // 即numbers[mid]位于b中
                // 最小值应为numbers[mid]或其右侧数值
                // 解空间变为[left,mid]
                right = mid;
            }else if (numbers[mid]==numbers[right]){
                // 由于重复元素的存在，无法确认numbers[mid]位置
//              // 除去b尾
                right--;
            }

        }

        return numbers[mid];

    }

}
