package util;
/**
 @author Shiyi Won
 注意堆的重要特征是一颗完全二叉树，即叶子节点只能出现在最后一层和倒数第一层，也就是说元素必须依次排布构建树，不能留空
 */
//构建堆与其操作
public class Heap {
    private int [] array; //存储堆的元素
    private int count; //元素个数
    private int capacity;//堆的大小
    private int heap_type;//1表示大根堆，0表示小根堆，下面的函数没有加判断条件，默认把堆当作大根堆

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setHeap_type(int heap_type) {
        this.heap_type = heap_type;
    }

    public int[] getArray() {
        return array;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }

    public Heap(int capacity, int heap_type){
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }
    //用数组创建堆树
    public static void buildHeap(Heap heap,int [] array,int n){
        if (heap == null){return;}
        while(n >heap.capacity){
            heap.resizeHeap();
        }
        for (int i =0;i<n;i++){
            heap.array[i] = array[i];
        }
        heap.count = n;
        //因为叶子节点满足堆的条件，所以从最后一个节点的父节点开始堆化各个元素
        //对非叶子节点堆化，节点的高度和是 n-h-1 = n -logn - 1,所以时间复杂度为O(n)
        for (int i=(n-1-1)/2;i>=0;i--){
            heap.percolateDown(i);
        }

    }
    //节点的双亲
    public int parent(int i){
        if(i <=0 || i >= this.count){
            return -1;
        }
        return (i -1)/2;
    }
    //节点的孩子
    public int leftChild(int i){
        int left = 2*i + 1;
        if (left >= this.count){
            return -1;
        }
        return left;
    }

    public int rightChild(int i){
        int right = 2*i + 2;
        if(right >= this.count){
            return -1;
        }
        return right;
    }

    //下面的方法用于堆化，即是将一个节点放到堆中的合适位置，因为节点的位置是向下的，所以又叫作向下渗透

    public void percolateDown(int i){
        int left,right,max,temp;
        left = leftChild(i);
        if (left !=-1 && this.array[left] > this.array[i]){
            max = left;
        } else {
            max = i;
        }
        right = rightChild(i);
        if (right !=-1 && this.array[right] > this.array[max]){
            max = right;
        }
        //上面两个if用于找出当前节点以及左右孩子节点中的最大值
        if(max != i){
             temp = this.array[i];
             this.array[i] = this.array[max];
             this.array[max] = temp;
             percolateDown(max);
        }
    }
    /**
     将第一个元素复制到其他变量
     将最后一个元素复制到第一个元素位置
     percolateDown(第一个元素)
     */
    public int deleteMax(){
        if(this.count == 0){
            return -1;
        }
        int data = this.array[0];
        this.array[0] = this.array[this.count -1];
        this.count--;
        percolateDown(0);
        return data;
    }
    //插入元素前如果发现堆已满则调整堆的大小
    public void resizeHeap(){
      /**
       虽然建堆的时候可能会用到这个函数，其中的复制数据的代码多余，但是当向堆中插入元素时确实有用的
       */
        int [] array_old = new int[this.capacity];
        System.arraycopy(this.array,0,array_old,0,this.count);
        this.array = new int[capacity*2];
        for(int i =0;i<array_old.length;i++){
            this.array[i] = array_old[i];
        }
        this.capacity *=2;
    }
    /**
     插入一个元素的做法是将元素总个数增加1，然后将要插入的元素放在这个位置，即是放在堆的尾部，然后从下到上根化这个元素
     */
    public void insertData(int data){
        int i;
        if (this.count == this.capacity){
            this.resizeHeap();
        }
        this.count++;
        i = this.count -1 ;//i现在指向的是堆的最后一个位置
        while(i>=0 && data >this.array[(i -1)/2]){
            /**如果双亲元素比它小那么双亲放到孩子的位置上，然后data上升到双亲的位置，如果
             上升到顶了或者data所在位置的双亲比它大，那么data就应该在这个地方
             */
            this.array[i] = this.array[(i-1)/2];
            i = (i - 1)/2;
        }
        this.array[i] = data;
    }

}
