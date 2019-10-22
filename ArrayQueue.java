import java.util.Arrays;

public class ArrayQueue<T> implements Queue {

    private Object[] a;
    private int front;
    private int rear;

    public ArrayQueue() {
        a = new Object[20];
        front = 0;
        rear = 0;
    }

    public Object dequeue() throws Exception {
        if(empty())
            throw new Exception("Queue empty");
        Object temp = a[front++];
        return temp;
    }

    public void enqueue(Object item) {
        if(rear == (a.length-1))
            grow_array();
        a[rear++] = item;
    }

    public boolean empty() {
        return front == rear;
    }

    void grow_array() {
        Object[] copy = Arrays.copyOfRange(a, 0, a.length*2);
        a = copy;
    }
}