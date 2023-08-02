public class ImplementStack {
    public static void main(String[] args) {
        StackusingLinkedList stack = new StackusingLinkedList();
        stack.push(2);
        stack.push(4);
        stack.push(8);
        System.out.println(stack.size());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}

class StackusingLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top;
    int count;

    StackusingLinkedList() {
        this.top = null;
        count = 0;
    }

    boolean isEmpty() {
        return top == null;
    }

    int peek() {
        if (top == null)
            return -1;
        return top.data;
    }

    void push(int x) {
        Node node = new Node(x);
        node.next = top;
        top = node;
        count++;
    }

    int pop() {
        if (top == null)
            return -1;
        int popData = top.data;
        top = top.next;
        count--;
        return popData;
    }

    int size() {
        return count;
    }
}
