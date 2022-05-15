package com.example.demo.code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//两个栈实现队列
public class letcode09 {
        Stack<Integer> stack1 ;
        Stack<Integer> stack2  ;

        public letcode09() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);

        }

        public int deleteHead() {
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.isEmpty()?-1:stack2.pop();
            }
        }
    }