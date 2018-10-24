package util;

public class ShellSort {
   public static int sort(int [] array){
       int count = 0;
       for(int gap = array.length/2;gap >0;gap/=2){
           for(int i = gap;i<array.length;i++){
               int j=i;
               int temp = array[i];
               while(j-gap >=0 && temp < array[j-gap]){
                   count++;
                   array[j] = array[j-gap];
                   j-=gap;
               }
               array[j] = temp;
           }
       }
       count++;
       return count;
   }
}
