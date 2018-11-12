import jdk.internal.cmm.SystemResourcePressureImpl;
import jdk.nashorn.tools.Shell;
import util.*;

import java.time.LocalDate;
import java.util.Arrays;

import static java.lang.System.*;
public class PublicClass implements Demo{

    public static void main(String []args){
      int []a = {1,2,3,34,2,25,13};
      int count = BucketSort.bucketSort(a);
      System.out.print(Arrays.toString(a)+"时间复杂度是:"+count);
    }
}

