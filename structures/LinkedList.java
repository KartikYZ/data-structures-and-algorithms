package structures;

public class LinkedList<T> {

    public LinkedListNode<T> iterativeReverse(LinkedListNode<T> head) {
        LinkedListNode<T> prev = null;
        LinkedListNode<T> current = head;
        LinkedListNode<T> next;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    public LinkedListNode<T> recursiveReverse(LinkedListNode<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        
        LinkedListNode<T> rev = this.recursiveReverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        
        return rev;
    }
}

class LinkedListNode<T> {
    private T data;
    private LinkedListNode<T> next;

    LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}
