
  class Node{
         int val;
         Node next;

        Node(int val){
            this.val=val;
            this.next=null;
        }
       
    }
    class MyLinkedList {
        Node head;
        int size;

  

    public MyLinkedList(){
        this.size=0;
        this.head=new Node(0);
    }
         
           
         
        
    
    
       public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node current = head.next; 
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }
    
    public void addAtHead(int val) {
      addAtIndex(0,val);
        
    }
    
    public void addAtTail(int val) {
    addAtIndex(size,val);
    }
    
    public void addAtIndex(int index, int val) {
        Node newNode=new Node(val);
        if(index > size){
            return;
        }
        if(index<0){
            index=0;
        }
        Node current=head;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        newNode.next=current.next;
        current.next=newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
         if(index < 0 || index>=size){
            return;
        }
        Node current=head;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        current.next=current.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */