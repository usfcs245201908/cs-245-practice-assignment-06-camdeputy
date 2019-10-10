
public class ArrayStack<String> implements Stack {

    private static final int DEFAULT_CAPACITY = 15;
    private int top;
    private String[] A;

    public ArrayStack(int initialCapacity) {
        if (initialCapacity <= 0)
            A = (String[]) new Object[DEFAULT_CAPACITY];
        else
            A = (String[]) new Object[initialCapacity];

        top = -1;   //stack is empty
    }

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public boolean empty() {
        return top == -1;
    }

    public String peek() throws Exception {
        if (empty()) throw new Exception("Stack is empty");
        return A[top];
    }

    public String pop() throws Exception {
        String x = peek();
        A[top] = null;
        top--;
        return x;
    }

    public void push(Object e) throws Exception {
        if (top == A.length)
            resize(A.length*2);
        top++;
        A[top] = (String) e;
    }

    private void resize(int capacity) {
        assert capacity >= A.length;

        // textbook implementation
        String[] temp = (String[]) new Object[capacity];
        for (int i = 0; i < A.length; i++) {
            temp[i] = A[i];
        }
        A = temp;
    }

}