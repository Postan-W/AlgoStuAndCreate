package util;

public class BinaryTree {
    public int data;
    public BinaryTree rChild;
    public BinaryTree lChild;
    public BinaryTree(int data){
        this.data = data;
    }
    public static BinaryTree tree_Generator(BinaryTree [] nodes){
        nodes[0].lChild = nodes[1];
        nodes[0].rChild = nodes[2];
        nodes[1].rChild = nodes[3];
        nodes[2].lChild = nodes[4];
        nodes[2].rChild = nodes[5];
        nodes[3].lChild = nodes[6];
        nodes[3].rChild = nodes[7];
        nodes[6].lChild = nodes[8];
        nodes[6].rChild = nodes[9];
        return nodes[0];
    }
    public static void pre_Traverse_Tree(BinaryTree head,int size){
        BinaryTree [] stack = new BinaryTree[size];
        int top =0;
        if(head!=null){
            stack[top++] = head;
        } else {
            return;
        }
        while(top >=1){
            BinaryTree temp = stack[--top];
            System.out.print(temp.data + "--");
            if (temp.rChild!=null){
                stack[top++] = temp.rChild;
            }
            if(temp.lChild!=null){
                stack[top++] = temp.lChild;
            }
        }
    }
}
