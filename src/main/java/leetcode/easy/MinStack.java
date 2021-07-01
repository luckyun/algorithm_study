package leetcode.easy;

import java.util.Stack;

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]

 *  Output
 * [null,null,null,null,-3,null,0,-2]

 * Explanation
 * MinStack minStack = new MinStack();
 *  * minStack.push(-2);
 * minStack.push(0);
 *  minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin() == -3); // return -3
        minStack.pop();
        System.out.println(minStack.top() == 0);    // return 0
        System.out.println(minStack.getMin() == -2); // return -2

    }

    private Stack<Node> stack;


    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Node(val, val));
        } else {
            stack.push(new Node(val, Math.min(val, stack.peek().minData)));
        }

    }

    public void pop() {

       stack.pop();

    }

    public int top() {
        return stack.peek().data;
    }

    public int getMin() {
        return stack.peek().minData;
    }

    public static class Node {
        private int data;
        private int minData;

        public Node(int data, int minData) {
            this.data = data;
            this.minData = minData;
        }
    }
}



