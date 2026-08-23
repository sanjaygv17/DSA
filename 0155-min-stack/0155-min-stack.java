class MinStack {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;

    int ptr=-1;

    public MinStack() {
        this.data=new int[DEFAULT_SIZE];
       
    }
    
    public void push(int value) {
        if(isFull()){
            int[] temp=new int[data.length*2];
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
        ptr++;
        data[ptr]=value;

        
    }
    
    public void pop() {
      if(isEmpty()){
        return;
      }  

      ptr--;
    }
    
    public int top() {
        return data[ptr];
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=ptr;i++){
            if(data[i]<min){
                min=data[i];
            }
        }
        return min;
        
    }
    public boolean isFull(){
        return ptr == data.length-1;
    }
    
    public boolean isEmpty(){
        return ptr == -1;
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