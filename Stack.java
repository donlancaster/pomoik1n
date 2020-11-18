import java.util.NoSuchElementException;

public class Stack<T> {
    private List<T> list;
    public Stack(){
        list = new List<>();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public boolean push(T data){
        if (data == null) return false;
        list.insertFirst(data);
        return true;
    }
    public T pop(){
        if (isEmpty()) throw new NoSuchElementException();
        else return list.deleteFirst();
    }
}
