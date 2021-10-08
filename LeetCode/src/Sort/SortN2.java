package Sort;

public class SortN2 {

    public static void main(String[] args) {
        int[] array = {4,7,2,8,14,5,5,9};
        SortN2 sortN2 = new SortN2();
        //sortN2.bubbleSort(array);
        //sortN2.insertSort(array);
        sortN2.selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    // 时间复杂度O(N^2)

    /**
     * 冒泡排序
     * 第i+1轮值两两比较，交换顺序，将最大数值移动到array[n-i-1]
    * */
    public void bubbleSort(int[] array){

        int length = array.length;
        if (length<2){
            return;
        }

        for (int i = 0; i < length ; i++) {

            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }

            if (!flag){
                break;
            }

        }

    }

    /**
     * 选择排序
     * 第i+1轮遍历数组[i-→length],选出最小值放入array[i]
     * */
    public void selectSort(int[] array){

        int length = array.length;
        if (length<2){
            return;
        }

        for (int i = 0; i < length ; i++) {

            int min = i;
            for (int j = i; j < length ; j++) {
                if (array[j]<array[min]){
                    min = j;
                }
            }

            if (min!=i){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }

        }

    }

    /**
     * 插入排序
     * 第i+1轮将array[i]与前面元素相比，如果小就插入前面的数组
     * 每一轮结束，前面的数组都是递增的
     * */
    public void insertSort(int[] array){

        int length = array.length;
        if (length<2){
            return;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }else {
                    break;
                }
            }
        }
    }

}
