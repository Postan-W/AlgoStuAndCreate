package util;

public class RotateTheString {
    //参数m表示将前面m个字符移到后面
    public static String rotateTheString1(String s, int m){
        int n = s.length();
        char [] chars = s.toCharArray();
        //该算法时间复杂度m乘n
        for (int j = 0; j < m;j++) {
            char c = chars[0];
            for (int i = 1; i < n; i++) {
                chars[i - 1] = chars[i];
            }
            chars[n - 1] = c;
        }
        return String.valueOf(chars);
    }
      //该算法时间复杂度为n
    public static String rotateTheString2(String s ,int m){
         char [] chars = s.toCharArray();
        //下面进行翻转
        reverse(chars,0,m-1);
        reverse(chars,m,chars.length -1);
        reverse(chars,0,chars.length-1);
        return String.valueOf(chars);
    }
    private static void reverse(char [] chars,int start, int end){
        while(start < end) {
            char t = chars[end];
            chars[end--] = chars[start];
            chars[start++] = t;
        }
    }
}
