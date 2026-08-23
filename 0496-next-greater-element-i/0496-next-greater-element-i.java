class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) { 
        
        
        for(int i=0;i<nums1.length;i++){
            int val=nums1[i];
            int index=0;
            boolean n=false;
            int next=0;
            for(int k=0;k<nums2.length;k++){
                if(nums2[k]==val){
                    index=k;
                }
            }
            for(int j=index;j<nums2.length;j++){
                if(nums2[j]>val){
                    n=true;
                    next=nums2[j];
                    break;
                }
                
            }
            if(n){
                nums1[i]=next;
            }else{
                nums1[i]=-1;
            }
            
        }
        return nums1;
    }
}