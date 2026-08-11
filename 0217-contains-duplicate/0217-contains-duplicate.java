class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet a=new HashSet();
        int count=0;
       for(int num:nums){
        if(!a.add(num)){
            return true;
        }
       }
      
            return false;
       
       
        
    }}