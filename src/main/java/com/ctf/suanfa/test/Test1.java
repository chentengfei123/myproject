package com.ctf.suanfa.test;

import com.ctf.suanfa.common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test1 {

    /**
     * 判断一个链表是为回文结构
     * push/pop
     */
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.get(0));
        System.out.println(stack.remove(0));
        System.out.println(stack.get(0));
        List list = new ArrayList();
        list.add("0");

    }

}
