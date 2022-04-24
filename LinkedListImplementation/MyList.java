package INF_HW.LinkedListImplementation;



public interface MyList<T> extends Collection, Iterable<T> {
    void add(T element);
    void remove(int index);
    T get(int index);
}
