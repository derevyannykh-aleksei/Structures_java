package structures;

public interface IList <T> {

    int getSizeList();
    void add (T elementToAdd);
    void add (T elementToAdd, int index);
    void remove (int index);
    boolean remove (T element);
    T get (int index);
    T set (T change, int index);
    int indexOf (T element);

}
