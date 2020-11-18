public class List<T> {
    private int size;
    private Node<T> first;
    public List(){
        first = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.next = first;
        first = newNode;
        size++;
    }
    public T deleteFirst(){
        T temp = first.data;
        first = first.next;
        size--;
        return temp;
    }
    public T first(){
        return first.data;
    }
    public int size(){
        return size;
    }
    public void displayList(){
        Node<T> current = first;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

class Node<T> {
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
    }
}
