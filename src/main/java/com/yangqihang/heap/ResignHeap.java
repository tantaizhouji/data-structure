package com.yangqihang.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 堆增加resign方法,可以修改堆中数据内容,保证总体数据符合堆的数据结构
 */
public class ResignHeap {
    public static class Student {
        public int id;
        public int age;
        public int classNo;

        public Student(int id, int age, int classNo) {
            this.id = id;
            this.age = age;
            this.classNo = classNo;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", age=" + age +
                    ", classNo=" + classNo +
                    '}';
        }
    }

    public static class MyHeap<T> {
        private ArrayList<T> heap;
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> com) {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            comparator = com;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public int size() {
            return heapSize;
        }

        public boolean contains(T key) {
            return indexMap.containsKey(key);
        }

        public void push(T t) {
            heap.add(t);
            indexMap.put(t, heapSize);
            heapInsert(heapSize++);
        }

        public T pop() {
            if (heap.size() == 0)
                throw new RuntimeException("heap is null");
            T result = heap.get(0); // 取出小根堆中的第一个元素
            int end = heapSize - 1;
            swap(0, end); // 堆中第一个元素和最后一个元素交换
            heap.remove(end); // 堆中将需要弹出的元素移除
            indexMap.remove(result); // indexMap中删除弹出的key的信息
            heapify(0, --heapSize);
            return result;
        }

        /**
         * 修改存在元素中的属性,并且使修改之后保持堆的结构
         *
         * @param t
         */
        public void resign(T t) {
            if (!contains(t))
                throw new RuntimeException("value is not in heap");
            int index = indexMap.get(t); // 获取元素的位置
            heap.set(index, t); // 更新heap中该位置的元素信息
            // 对更新的index位置的元素重新进行上滤或者下滤,上滤和下滤之后进行一个
            heapInsert(index);
            heapify(index, heapSize);
        }

        private void heapInsert(int index) {
            // 比较index位置的数和它父节点位置的数
            while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
                // index位置的数小于父节点位置的数,进行循环操作
                swap(index, (index - 1) / 2); // 交换两个位置的数
                index = (index - 1) / 2; // 指针位置移动到交换后的节点位置
            }
        }

        /**
         * 堆化
         *
         * @param begin 需要堆化的元素位置
         * @param end   边界位置
         */
        private void heapify(int begin, int end) {
            int left = (begin << 1) | 1; // 左子节点位置
            while (left < end) {
                // 右子节点存在且右子节点小于左子节点,最小位置是右子节点.不满足最小位置是左子节点
                int smallest = left + 1 < end && (comparator.compare(heap.get(left + 1), heap.get(left)) < 0)
                        ? left + 1 : left;
                // 最小位置是否比父节点位置的值小
                smallest = comparator.compare(heap.get(smallest), heap.get(begin)) < 0 ? smallest : begin;
                if (smallest == begin)
                    break; // 最小位置为父节点位置,跳出循环
                swap(begin, smallest); // 交换
                begin = smallest;
                left = (begin << 1) | 1;
            }
        }

        /**
         * 交换i,j两个位置的元素,和indexMap中的信息
         *
         * @param i 位置1
         * @param j 位置2
         */
        private void swap(int i, int j) {
            T tmp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, tmp);
            indexMap.put(heap.get(i), j); // 更新indexMap中元素记录的位置
            indexMap.put(heap.get(j), i);
        }
    }

    public static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        MyHeap<Student> heap = new MyHeap<>(new StudentComparator());
        Student a = new Student(1, 20, 110);
        Student b = new Student(2, 18, 120);
        Student c = new Student(3, 22, 100);
        Student d = new Student(4, 21, 100);
        Student e = new Student(5, 16, 110);
        Student f = new Student(6, 23, 130);
        heap.push(a);
        heap.push(b);
        heap.push(c);
        heap.push(d);
        heap.push(e);
        heap.push(f);

        c.age = 15;
        heap.resign(c);

        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
    }
}
