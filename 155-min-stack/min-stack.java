class MinStack {
    static class Node{
        int data, min;
        Node next;

        Node(int data, int min) {
            this.data = data;
            this.min = min;
            this.next = null;
        }
    }
    Node head; 
    public MinStack() {
        head = null;
    }
    
    public void push(int value) {
        if( head == null ) {
            head = new Node(value, value);
        } else {
            Node newNode = new Node(value, Math.min(value, head.min));
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void pop() {
        if( head != null ) {
            head = head.next;
        }
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */