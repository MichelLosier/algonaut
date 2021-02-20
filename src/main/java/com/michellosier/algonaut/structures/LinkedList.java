class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        
    }

    public <T> get(T index) {
        int pos = 0;
        Node curNode = this.head;
        
        while (curNode != null){
            if (pos == index) {
                return curNode.getVal();
            }
            pos++;
            curNode = curNode.getNext();
        }
        
        return -1;
    }
    
    public <T> void addAtHead(T val) {
        Node newHead = new Node<T>(val);
        
        if (this.head == null) {
            this.head = newHead;
            return;
        }
        
        newHead.setNext(this.head);
        this.head = newHead;
    }
    
    public <T> void addAtTail(T val) {
        Node curNode = this.head;
        
        if (curNode == null) {
            this.head = new Node<T>(val);
            return;
        }
        
        while(curNode.getNext() != null){
            curNode = curNode.getNext();
        }
        
        Node newTail = new Node<T>(val);
        curNode.setNext(newTail);
    }
    
    public <T> void addAtIndex(int index, T val) {
        int pos = 0;
        Node curNode = this.head;
        
        if (index == 0) {
            this.addAtHead(val);
        }
        
        while (curNode != null) {
            if ((pos + 1) == index) {
                Node newNode = new Node<T>(val);
                Node prevNext = curNode.getNext();
                newNode.setNext(prevNext);
                curNode.setNext(newNode);
                return;
            }
            pos++;
            curNode = curNode.getNext();
        }
    }
    
    public void deleteAtIndex(int index) {
        int pos = 0;
        Node curNode = this.head;
        
        if (index == 0) {
            this.head = (curNode != null) ? curNode.getNext() : null;
        }
        
        while (curNode.getNext() != null) {
            if ((pos+1) == index){
                Node newNext = curNode.getNext().getNext();
                curNode.setNext(newNext);
                return;
            }
            pos++;
            curNode = curNode.getNext();
        }
    }
    
    private class Node<T> {
        private T val;
        private Node<T> next;
        
        public Node(T val) {
            this.val = val;
        }
        
        public Node<T> getNext() {
            return this.next;
        }
        
        public void setNext(Node<T> next) {
            this.next = next;
        }
        
        public <T> getVal(){
            return this.val;
        }
        
        public <T> void setVal(T val) {
            this.val = val;
        }
    }
}