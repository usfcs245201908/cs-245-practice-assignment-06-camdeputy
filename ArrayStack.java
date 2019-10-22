import java.util.Arrays;

public class ArrayStack<T> implements Stack {

    private Object[] a;
    private int size;

    public ArrayStack() {
        a = new Object[20];
        size = -1;
    }

    public boolean empty() {
        return size == -1;
    }

    public Object peek() throws Exception {
        if(empty())
            throw new Exception("Stack empty");
        return a[size];
    }

    public Object pop() throws Exception {
        if(empty())
            throw new Exception("Stack empty");
        Object temp = a[size--];
        return temp;
    }

    public void push(Object item) throws Exception {
        if(size == (a.length-1))
            grow_array();
        a[++size] = item;
    }

    private void grow_array() {
        Object[] copy = Arrays.copyOfRange(a, 0, a.length*2);
        a = copy;
    }

}