package util;
/**
 @author Shiyi Won
 @time 2018.11.09
 @name 选择排序,原地排序(不需要额外的空间)，时间复杂度O(n)
 */
public class SelectionSort {
    public static void selectionSort(int [] array){
        int temp;
        int min;
        for (int i=0;i<array.length;i++){
            min=i;
            for (int j=i+1;j<array.length;j++){
                if (array[j] <array[min]){
                    min=j;
                }
            }
            if (min !=i){
                temp = array[min];
                array[min] = array[i];
                array[i] =temp;
            }
        }
    }
}
