package Sort;

public class SortNlogN {

    public static void main(String[] args) {

        int[] array = {4,7,2,8,14,5,5,9};
        SortNlogN sortNlogN = new SortNlogN();
        sortNlogN.quickSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    // 时间复杂度O(N*logN)

    /**
     * 快排
     * 平均时间复杂度=O(N*logN), 最坏O(N^2)
     * 每一轮选定一个基准值pivot，将小于pivot的所有数移动到其左边，大于pivot的数移动到右边，
     * eg:以数组头为基准，右指针左移到小于基准的元素，左指针右移到大于准的元素，交换
     *      当左右指针相遇，将当前元素与数基准组头交换
     * 完成对pivot的排序后，继续在pivot的左右两个子区间进行快速排序。
     * */
    public void quickSort(int[] array,int left,int right){

        if (left>right){
            return;
        }

        int length = array.length;
        if (length<2){
            return;
        }

        int i = left, j = right;
        int pivot = array[left], temp = 0;

        while (i<j){

            while (array[j]>=pivot && i<j){
                j--;
            }
            while (array[i]<=pivot && i<j){
                i++;
            }

            if (i<j){
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }

        }

        array[left] = array[i];
        array[i] = pivot;

        quickSort(array,left,j-1);
        quickSort(array,j+1,right);

    }

}
