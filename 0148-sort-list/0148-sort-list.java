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
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        

        ListNode mid=getMid(head);
        ListNode right=mid.next;
        mid.next=null;

        ListNode left=sortList(head);
        right=sortList(right);

        return merge(left,right);
    }
    
    public ListNode getMid(ListNode node){

        ListNode slow=node;
        ListNode fast=node.next;
     
        while(fast != null && fast.next != null){
            
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

  

    public ListNode merge(ListNode first,ListNode second){
        ListNode mix=new ListNode();
        ListNode dummy=mix;

        while(first != null && second != null){
            if(first.val < second.val){
                dummy.next=first;
                first=first.next;

            }else{
                dummy.next=second;
                second=second.next;
            }
            dummy=dummy.next;
        }

        if(first != null){
            dummy.next=first;
        }

        if( second != null){
            dummy.next=second;
        }

        return mix.next;
    }
}