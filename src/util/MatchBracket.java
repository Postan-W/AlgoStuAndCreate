package util;
/**
 @author Shiyi Won
 @time 2018.10.25
 @name 匹配括号问题
 */
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class MatchBracket {
 /*   private char [] bracket;
    private int maxSize;
    public MatchBracket(char [] bracket,int maxSize){
        this.bracket = bracket;
        this.maxSize = maxSize;
    }*/
    public static boolean match(String brackets){
        char [] bracketChars = brackets.toCharArray();
        char [] stack = new char[bracketChars.length];
        int top = 0 ;
        for (int i=0;i < bracketChars.length;i++){
            System.out.println(bracketChars[i]);
            switch(bracketChars[i]){
                case '['|'{'|'(':stack[top++] = bracketChars[i];
                case ')':if (top==0 || stack[--top]!='(') return false;
                case ']':if (top==0 || stack[--top]!='[') return false;
                case '}':if (top==0 || stack[--top]!='{') return false;
            }
        }
        if (top ==0){
            return true;
        } else {
            return false;
        }

    }
}
