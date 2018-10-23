package util;

public class PopSort {
    public static int popSort(int [] array){
        int count =0;
        for(int i=0; i < array.length-1;i++){
            for (int j=0;j <array.length-1-i;j++){
                count++;
                if (array[j] >array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    return count;
    }
}
