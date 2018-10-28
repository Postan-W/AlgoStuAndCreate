import util.Heap;

/**
 @author Shiyi Won
 @time 2018.10.27
 @name HeapSort
 堆排序的实现(升序)，堆的建立已在其他类中实现.利用堆的根节点最大的特点(大根堆），每次将,根节点与最后一个元素交换，然后
 将堆的元素个数减1，然后将这个交换后新的根节点(因为可能不满足堆)，进行堆化，重复以上过程知道最后金剩下一个节点，这时
 保存堆元素的那个数组就是升序的了
 */

public class HeapSort {
    public static void heapSort(int [] array,int n){
        Heap heap = new Heap(20,1);
        Heap.buildHeap(heap,array,n);
        int size = n -1;
        int length = n;
        while(size > 0) {
            System.out.println(heap.getArray()[0]);
            int temp = heap.getArray()[0];
            heap.getArray()[0] = heap.getArray()[size];
            heap.getArray()[size] = temp;
            size--;
            heap.setCount(heap.getCount() -1);
            heap.percolateDown(0);
        }
    }
}
