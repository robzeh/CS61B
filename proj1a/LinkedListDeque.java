public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    public class Node {
        public Node prev;
        public Node next;
        public T item;

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node newFirst = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newFirst;
        sentinel.next = newFirst;
        size++;
    }

    public void addLast(T item) {
        Node newLast = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newLast;
        sentinel.prev = newLast;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel;

        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        sentinel.prev.next = sentinel.next.next;

        size--;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T item = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;

        size--;
        return item;
    }

    public T get(int index) {
        if (size == 0) {
            return null;
        }

        Node p = sentinel;
        T item = null;
        while (p.next != sentinel) {
            if (size == index + 1) {
                item = p.item;
            }
            p = p.next;
        }

        return item;
    }


}
