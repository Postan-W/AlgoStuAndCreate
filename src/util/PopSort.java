package util;
/**
 @author Shiyi Won
 @time 2018.10.25
 @name 冒泡排序,空间复杂度O(1),非优化情况下时间复杂度O(n*n)
 */
public class PopSort {
    public static int popSort(int [] array){
        //添加一个交换标记，如果某一次循环中没有进行交换，那么外层循环就不再继续下去了
        int swapped =1;
        int count =0;
        int temp;
        for(int pass=array.length -1; pass >0 &&swapped==1;pass++){
            swapped =0;
            for (int j=0;j <pass;j++){
                if (array[j] >array[j+1]){
                    count+=3;//计算交换的次数
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = 1;//一次循环下来如果大于或等于一次交换swapped的值都会为1，否则已经有序
                }
            }
        }
    return count;
    }
}
