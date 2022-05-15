package com.example.demo.code;

import java.util.Stack;

//相同点：大家都返回栈顶的值。
//
//不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。

public class MinStack {

    Stack<Integer> stack1 ;
    Stack<Integer> stack2 ;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    //TODO 注意这个<=

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }

    }

    public void pop() {
        int x = stack1.pop();
        if (x == stack2.peek())
            stack2.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return stack1.peek();

    }

    public int min() {
        if (stack2.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return stack2.peek();

    }

}
