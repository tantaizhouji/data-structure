package com.yangqihang.heap;

/**
 * 大根堆
 */
public class MyMaxHeap {
    private int[] heap;
    private int heapSize; // 即表示当前堆的大小,也表示新元素加入堆中的指针
    private final int LIMIT;

    public MyMaxHeap(int limit) {
        this.LIMIT = limit;
        heapSize = 0;
        heap = new int[limit];
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == LIMIT;
    }

    public void push(int value) {
        if (heapSize == LIMIT)
            throw new RuntimeException("heap is full");
        heap[heapSize] = value; // 新增的值放入到heapSize的位置中
        heapInsert(heap, heapSize++); // 将新增的值进行位置调整,调整完之后heapSize加1
    }

    /**
     * 弹出大根堆最大值
     *
     * @return
     */
    public int pop() {
        if (heapSize == 0)
            throw new RuntimeException("heap is null");
        int result = heap[0];
        swap(heap, 0, --heapSize); // 交换大根堆第一个位置值和最后一个位置值,完成后heapSize-1
        heapify(heap, 0, heapSize); // 将交换之后的堆重新大根堆化
        return result;
    }

    /**
     * 调整堆给定位置的值的位置
     *
     * @param index 给定索引
     */
    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) { // 当前位置值大于当前位置的父节点的值,值需要和当前父进行交换,如果到了根节点或者小于父节点值,结束
            swap(arr, index, ((index - 1) / 2));
            index = (index - 1) / 2; // 指针指向交换之后的位置
        }
    }

    /**
     * 堆化
     *
     * @param arr      需要堆化的数组
     * @param index    堆化的起始指针
     * @param heapSize 堆的大小,也是堆的边界指针
     */
    private void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) | 1; // 左子节点的位置
        while (left < heapSize) { // 左子节点是否越界
            // 获得左右子节点中最大的节点位置,判断右子节点不越界的同时,右子节点的值大于左子节点
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index; // 判断最大子节点的值是否大于父节点
            if (largest == index)
                break; // 最大节点的位置就是当前位置,跳出循环
            swap(arr, index, largest);
            index = largest; // 当前指针移动到最大子节点的位置
            left = (index << 1) | 1; // 更新左子节点
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
