package util;
/**
 桶排序。利用一个容积为要排序列中最大数的‘桶’来表示要排序列中元素出现的次数。即用
 桶的下标来记录待排序列的元素，某个元素出现n次，那么桶的这个位置的值即是n。
 */
public class BucketSort {
    public static int bucketSort(int [] array){
        //先找出数组中的最大元素
        int max =array[0];
        for(int i =1;i<array.length;i++){
            if (array[i] >max){
                max = array[i];
            }
        }
        int []bucket = new int[max+1];
        int count =0; //记录时间复杂度
        //下面构造桶，时间复杂度固定为array.length
        for (int i =0;i<array.length;i++){
            ++bucket[array[i]];
            count++;
        }
        for (int i =0,k=0;i<max;i++){
            for (int j =0;j<bucket[i];j++){
                array[k++] =i;
                count++;
            }
        }
        return count;
    }
}
