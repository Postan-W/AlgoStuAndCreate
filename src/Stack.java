public class Stack {
    private char [] number;
    private int top;
    public Stack(int maxSize){
        this.number = new char[maxSize];
            this.top = -1;
    }
    public char[] getArray(){
        return this.number;
    }
    public char pop(){
        if (top >= 0) {
            return number[top--];
        } else{
            System.out.println("栈空");
        }
        return 'e';
    }
    public void push(char c){
        if (++top >this.number.length){
            System.out.println("栈已满");
            return;
        }
        number[++top]= c;
    }
}
