import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class MinStack {
	
	private Stack<Integer> s = new Stack<Integer>();
	private Stack<Integer> smin = new Stack<Integer>();
	
    public void push(int x) {
        s.push(x);
        if (smin.isEmpty())
        	smin.push(x);
        else
        	smin.push(Math.min(x, smin.peek()));
    }

    public void pop() {
        s.pop();
        smin.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return smin.peek();
    }
    
}

class MyStack {
	private Queue<Integer> q = new LinkedList<Integer>();
	
    // Push element x onto stack.
    public void push(int x) {
    	int size = q.size();
        int[] aux = new int[size];
        for (int i = 0; i < size; i++)
            aux[i] = q.remove();
        q.add(x);
        for (int i = 0; i < size; i++)
        	q.add(aux[i]);
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.remove();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}

class MyQueue {
	private Stack<Integer> s = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        int size = s.size();
        int[] aux = new int[size + 1];
        for (int i = 0; i < size; i++)
            aux[i] = s.pop();
        aux[size] = x;
        for (int i = size; i >= 0; i--)
        	s.push(aux[i]);
    }

    // Removes the element from in front of queue.
    public void pop() {
        s.pop();
    }

    // Get the front element.
    public int peek() {
        return s.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s.isEmpty();
    }
}
