/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 import java.util.Random;
 

class Solution {
    ListNode node;
     Random rand;



    public Solution(ListNode head) {
      this.node=head;
      this.rand=new Random();
      
        
    }
    
    public int getRandom() {
        ListNode list=node;
        int l=length();
        int random=rand.nextInt(l);
      
        for(int i=0;i<random;i++){
            list=list.next;
        }
        return list.val;
        
    }
    public int length(){
        int l=0;
        ListNode current=node;
        while(current != null){
            current=current.next;
            l++;
        }
        return l;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */