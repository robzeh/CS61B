public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst, nextLast;
    private static final int REFACTOR = 2;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
}
