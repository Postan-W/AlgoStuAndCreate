package util;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.*;
/**
 @author  Shiyi Won
 @time 2018.10.29
 @theme 图的定义及深度与广度遍历，基于临接矩阵,时间复杂度O(n的平方)
 */
//变量均公开
public class Graph {
    public int vertices_num;
    public char data[];
    public int weight[][];//存储边与边的关系
    public int [] visited;//这个数组的作用是保存已经被访问过的节点

    public Graph(char data[],int weight[][]){
        this.vertices_num = data.length;
        this.data = new char[vertices_num];
        this.visited = new int[vertices_num];
        this.weight = new int[vertices_num][vertices_num];
        for (int i =0; i<data.length;i++){
            this.data[i] = data[i];
        }
        for (int j = 0;j<data.length;j++){
            for (int k=0;k<data.length;k++){
                this.weight[j][k] = weight[j][k];
            }
        }
    }

    //获取某节点的第一个相邻点
    public int getFirst(int k) throws ArrayIndexOutOfBoundsException{
        if( k <0 || k>this.vertices_num -1){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = 0;i<this.vertices_num;i++){
                //节点自己与自己的weight值设置为0
                if (this.weight[k][i] == 1){
                    return i;
                }
            }
        }
        return -1;
    }
    //获取节点k的相邻节点j之外的另一个相邻节点
    public int getNext(int k, int j) throws ArrayIndexOutOfBoundsException{
        if ( k<0 || k>this.vertices_num -1 || j <0 || j>this.vertices_num){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for (int i = j+1;i<this.vertices_num;i++){
                if (this.weight[k][i] == 1){
                    return i;
                }
            }
        }
        return -1;
    }
    //深度优先遍历图,参数k是某个节点的序号
    //DFS的思路是访问某个节点及其相邻节点，直到某个节点没有相邻节点，然后回退到上一个节点的相邻节点，重复这个过程
    public void DFS(int k){
        int u; //节点k的邻接节点
        out.print(this.data[k] + "-->");
        visited[k] = 1;
        u = getFirst(k);
        while (u != -1) {
        if (visited[u] ==0){
            DFS(u);//从这里开始深度预先遍历相邻节点
        }
        u = getNext(k,u);//相邻节点遍历完后再回到下一个相邻节点
        }
        }
        //广度优先遍历的思路是先遍历一个节点的所有节点，然后依次对它所有的节点进行这样的操作
    /**根据队列先进先出的特点，一个节点的相邻节点依次访问，那么它的相邻节点的相邻节点也具有这样的先后次序
       与队列先进先出的特点一致.
        代码实现的思路是当队列不为空时，取出一个节点访问他，然后把他所有的节点依次进队列知道没有相邻节点，
        然后再取出头部那个节点，重复这样的操作。因为一个节点的相邻节点也有可能相邻，所以也要判断是否被访问过
     */
    public void BFS(int k){
        Queue<Integer> queue = new LinkedList<Integer>();//linkedlist既可以作队列也可以作栈，这取决于引用的类型
        int u;
        queue.add(k);
        this.visited[k] = 1;
        while(!queue.isEmpty()){
            u = queue.remove();
            out.print(data[u] + "-->");
            int v = getFirst(u);
            while(v !=-1){
                if (visited[v]!=1){
                    queue.add(v);
                    visited[v] =1;
                 }
                 v = getNext(u,v);
            }
        }
    }
}
