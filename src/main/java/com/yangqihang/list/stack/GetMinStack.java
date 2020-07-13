package com.yangqihang.list.stack;

/**
 * 实现一个特殊的栈,在基本功能的基础上,再实现返回栈中最小元素的功能
 */
public class GetMinStack {
    private ArrayStack<Integer> stackData; // 数据栈
    private ArrayStack<Integer> stackMin;  // 最小栈

    public GetMinStack() {
        stackData = new ArrayStack<>();
        stackMin = new ArrayStack<>();
    }

    public void push(int e) {
        if (stackMin.isEmpty()) {
            stackMin.push(e);
        } else if (getMin() < e) {
            int min = getMin();
            stackMin.push(min);
        } else {
            stackMin.push(e);
        }
        stackData.push(e);
    }

    public int pop() {
        if (this.stackData.isEmpty())
            throw new RuntimeException("stack is null");
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if (stackMin.isEmpty())
            throw new RuntimeException("stack is null");
        return stackMin.peek();
    }
}
