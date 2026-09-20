class Solution {
    public int reverseDegree(String s) {
        if( s == null ){
            return 0;
        }
        s=s.toLowerCase();
        int ans=0;
        for(int i=1;i<s.length()+1;i++){
            char c=s.charAt(i-1);
            int index='z'- c + 1;
            ans=ans+(i*index);
        }

        return ans;
    }
}