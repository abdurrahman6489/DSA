public class ImplementStackArray {
    public static void main(String[] args) {
        StackusingArray stack = new StackusingArray();
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

class StackusingArray {
    int top;
    int max;
    int[] stack;

    StackusingArray() {
        this.max = 100;
        stack = new int[max];
        this.top = -1;

    }

    boolean isEmpty() {
        return top == -1;
    }

    int peek() {
        if (top == -1)
            return -1;
        return stack[top];
    }

    int size() {
        if (top == -1)
            return 0;
        return top + 1;
    }

    void push(int a) {
        if (top + 1 == max)
            return;
        top++;
        stack[top] = a;
    }

    int pop() {
        if (top == -1)
            return -1;
        int popData = stack[top];
        top--;
        return popData;
    }
}
