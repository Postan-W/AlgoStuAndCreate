package util;

/**
 @author Shiyi Won
 @time 2018.10.24
 @name 归并排序
 */
public class MergeSort {
    //用于分割序列
    public static void mergeSort(int [] array,int low ,int high){
        int mid = (low +high)/2;
        if(low < high){
            mergeSort(array,low,mid);
            mergeSort(array,mid +1,high);
            merge(array,low,mid,high);
        }

    }
    //用于将两个有序序列合并为一个有序序列
    public static void merge(int []array, int low ,int mid,int high){
        int i = low , j = mid + 1,k = 0;
        int [] temp = new int[high-low +1];
        while ((i <= mid) && (j <= high)){
            if(array[i] < array[j]){
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while(i <= mid) temp[k++] = array[i++];
        while(j <= high) temp[k++] = array[j++];
     for (int t =0 ; t < temp.length; t++){
         array[t+low] = temp[t];
     }
    }

}
