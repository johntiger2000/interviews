package jun.aerserv;

public class SimpleStack {

    class Node {
        int val;
        Node next;
        
        public Node(int val) {
            this.val = val;
        }
        
    }
    
    protected Node head;
    protected long size;
    
    public void push(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        ++size;
    }

    public int pop() {
        if (head == null) {
            throw new RuntimeException("pop empty stack!");
        }
        int ret = head.val;
        head = head.next;
        --size;
        return ret;
    }

    public long size() {
        return size;
    }

}
