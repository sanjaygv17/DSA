class Solution {
    public boolean digitCount(String num) {
        int[] nums=new int[10];

        for(int i=0;i<num.length();i++){
            int digit=num.charAt(i) - '0';
            nums[digit]+=1;
        }

        for(int i=0;i<num.length();i++){
            int expected=num.charAt(i) - '0';
            if( nums[i] != expected){
                return false;
            }
        }

        return true;

    }
}