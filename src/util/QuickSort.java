package util;
//默认升序
public class QuickSort {
    public static void quickSort(int [] array,int low,int high) {
        int tag1 = low;
        int tag2 = high;
        if (low < high) {
            int temp = array[low];//为第一次的循环腾出了位置
            while (low < high) {
                //high右边的均大于temp
                while (low < high && array[high] >= temp) {
                    high--;
                }
                array[low] = array[high];//将小于temp的值放到low处，并为下面的循环滕开了一个位置，并启动了下一次循环
                while (low < high && array[low] < temp) {
                    low++;
                }
                array[high] = array[low];
            }
            array[high] = temp;
            quickSort(array,tag1,high-1);
            quickSort(array,high+1,tag2);
        }
    }


}
