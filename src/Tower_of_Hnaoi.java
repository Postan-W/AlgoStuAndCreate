
/**
 @author Shiyi Won
 @time 2018.10.25
 @name 汉诺塔问题
 */
public class Tower_of_Hnaoi {
    public static int step = 1;
    public static  void hanoi(int number,char start,char mid,char end){
        if(number ==1){
            System.out.println("第"+step+"步："+start +" ---> "+end);
            step++;
        } else {
            hanoi(number -1,start,end,mid);
            System.out.println("第"+step+"步："+start +" ---> "+end);
            step++;
            hanoi(number -1,mid,start,end);
        }
    }
}
