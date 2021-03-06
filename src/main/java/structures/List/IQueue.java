package structures.List;

public interface IQueue<T> {
    int getSizeQueue();

    void put(T elementToAdd);

    T firstElement();

    T get();
}
