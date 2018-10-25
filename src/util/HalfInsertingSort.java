package util;
/**
 @author Shiyi Won
 @time 2018.10.25
 @name 折半插入排序
 */
public class HalfInsertingSort {
    public static int sort(int [] array){
        int count = 0;
        for(int i =1;i < array.length;i++){
            int temp = array[i];
            int j;
            int low = 0, high = i-1;
            while(low <=high){
                count++;
                int middle = (low +high)/2;
                if (array[middle] >= temp){
                    high = middle -1;
                } else {  low = middle +1;}
            }//无论这个while循环是在哪个判断条件执行后跳出的，都不会影响下面的写法
            for (j=i-1;j>=high+1;j--){
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
        return count;
    }
}
