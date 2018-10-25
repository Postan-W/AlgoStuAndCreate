package util;
/**
 @author Shiyi Won
 @time 2018.10.25
 @name 直接插入排序
 */
public class DInsertingSort {
    public static int Sort(int [] array){
        int count =0;
        for(int i =1 ; i< array.length;i++){
            int temp = array[i];
            int j;
            for(j=i;j > 0 && temp <array[j-1];j--){
                    count++;
                    array[j] = array[j-1];
            }
            array[j] = temp;
        }
        return count;
    }
}
