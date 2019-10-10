public class ArrayQueue<String> implements  Queue<String> {
    private static final int DEFAULT_CAPACITY = 10;
    private int cap,
            cur,
            front,
            back;
    private String[] A;

    public ArrayQueue() {
        cap = DEFAULT_CAPACITY;
        A = (String[]) new Object[DEFAULT_CAPACITY];
        back = -1;
        front = 0;
    }

    public boolean empty() {
        return cur == 0;
    }

    public void enqueue(String value) {
        if (isFull())
            resize(A.length*2);
        back++;
        A[back % cap] = value;
        cur++;
    }

    public String getFront() throws Exception {
        if (empty())
            throw new Exception();
        else
            return A[front % cap];
    }

    public String dequeue() throws Exception {
        String e = getFront();
        A[front % cap] = null;
        front++;
        cur--;
        return e;
    }

    public boolean isFull() {
        return cur == cap;
    }

    public void resize(int reSize){
        String[] tmp = (String[]) new Object[reSize];

        int current = front;
        for (int i = 0; i < A.length; i++)
        {
            tmp[i] = A[current];
            current = (current + 1) % A.length;
        }
        A = tmp;

    }
}