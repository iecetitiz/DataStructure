package linkedList.my.singlyLinkedList;

public class SinglyLinkedList {
    Node head;
    Node tail;
    int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            tail = node;
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size += 1;
    }

    public void addLast(int value) {
        if(isEmpty()) {
            addFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size +=1;
    }

    public void insertAnIndex(int value, int index) {
        if(index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }

        Node temp = head;
        for(int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value);
        node.next = temp.next; //ucan balon
        temp.next = node;
        size += 1;
    }

    public int deleteFirst() { //tricky!!!!
        //bu methodla hem tek eleman olmayi hem de listin bos olmasini kontrol ediyorum

        int val = head.value;
        head = head.next;
        if(head == null) { //ilk nodeu silerken belki de son node'u silmisimdir
            tail = null;
        }
        size -= 1; //silerken size'lari azaltmayi unutma
        return val;
    }

    public int deleteLast() {
        if(size <= 1) {
            return deleteFirst();
        }

        Node secondLast = getNode(size -2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size -= 1;
        return val;

    }

    public int deleteFromIndex(int index) {

        if(index == 0) {
            return deleteFirst();
        }
        if(index == size - 1) {
            return deleteLast();
        }

        Node prev = getNode(index -1);
        Node current = getNode(index);
        int val = current.value;
        prev.next = current.next;
        size -= 1;
        return val;
    }

    public Node getNode(int index) { //onemli bi method
        Node temp = head;

        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void deleteGivenKey(int key) {
        Node current = head;
        Node temp = null;

        if(current != null && current.value == key){
            head = current.next;
            return;
        }

        while(current != null && current.value != key){
            temp = current;
            current = current.next;
        }

        if(current == null){
            return;
        }

        temp.next = current.next;
    }

    public boolean find(int key) {
        if(head == null) {
            return false;
        }

        Node current = head;
        while(current != null) {
            if(current.value == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void print() {
        Node node = head;
        if(node == null) {
            System.out.println("list is empty!");
            return;
        }
        while(node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }

    public void swapWithNext(int index) {
        Node beforep = getNode(1);
        Node p = beforep.next;
        Node afterp = p.next;

        p.next = afterp.next;
        beforep.next = afterp;
        afterp.next = p;

        //beforep.next = afterp;
        //p.next = afterp.next;
        //afterp.next = p;
    }

    public void insertBefore(int index, int newValue) {
        Node p = getNode(index);
        Node newNode = new Node(newValue);
        newNode.next = p.next;
        p.next = newNode;
        newNode.value = p.value;
        p.value = newValue;
    }

    public void deleteNode(int index) { //benden sonrakini harciyorum
        Node p = getNode(index);
        p.value = p.next.value;
        p.next = p.next.next;
    }

    public void logicallyRemove(int index) {
        Node ref = getNode(index);
        ref.value = ref.next.value;
        ref.next = ref.next.next;
    }

    void remove_duplicates()
    {
        Node node1 = head;
        Node node2 = null;

        while (node1 != null && node1.next != null) {
            node2 = node1;

            while (node2.next != null) {
                if (node1.value == node2.next.value) {
                    node2.next = node2.next.next;
                }
                else {
                    node2 = node2.next;
                }
            }
            node1 = node1.next;
        }
    }
}
