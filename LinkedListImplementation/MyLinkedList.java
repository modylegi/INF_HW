package INF_HW.LinkedListImplementation;


import java.util.List;

class MyLinkedList<E> {

    private class Node {
        public Node next;
        public E data;

        public Node(){
            this(null, null);
        }

        public Node(E data){
            this(data, null);
        }

        public Node(E data, Node next){
            this.next = next;
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public E get(int index){
        if(index == 0)
            return head.data;
        else {
            int count = 0;
            Node current = head;
            while(count < index){
                current = current.next;
                count++;
            }
            return current.next.data;
        }
    }

    public void addFirst(E element){
        if(head  == null){
            head = new Node(element);
        } else {
            head = new Node(element, head);
        }
        size++;
    }

    public void addLast(E element){
        if(head == null)
            head = new Node(element);
        else {
            Node current = head;
            while(current.next != null)
                current = current.next;
            current.next = new Node(element);
            size++;
        }
    }

    public void add(int index, E element){
        if(index == 0){
            addFirst(element);
        }
        else{
            Node current = head;
            int count = 0;
            while(count < index-1 ){
                current = current.next;
                count++;
            }
            Node tmp = current.next;
            current.next = new Node(element, tmp);
        }
        size++;
    }

    public E remove(int index){
        Node tmp;
        if(index == 0) {
            tmp = head;
            head = head.next;
        }
        else {
            Node current = head;
            int count = 0;
            while(count < index-1){
                current = current.next;
                count++;
            }
            if(current.next.next == null) {
                tmp = current.next;
                current.next = null;
            }
            else {
                tmp = current.next;
                current.next = current.next.next;
            }
        }
        size--;
        return tmp.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        if(isEmpty())
            return "[]";
        else {
            String result = "";
            Node current = head;
            result = "[" + current.data;
            while(current.next != null){
                result += ", " + current.next.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
}