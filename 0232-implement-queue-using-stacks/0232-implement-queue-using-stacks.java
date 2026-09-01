import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    private Deque<Integer> input;
    private Deque<Integer> output;

    public MyQueue() {
        this.input=new ArrayDeque<>();
        this.output=new ArrayDeque<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        stackswitch();
        return output.pop();
    }
    
    public int peek() {
        stackswitch();
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public void stackswitch(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */