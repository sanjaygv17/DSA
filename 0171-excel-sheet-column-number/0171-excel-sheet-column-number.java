class Solution {
    public int titleToNumber(String columnTitle) {
        int length=columnTitle.length();
        int result=0;
        for(int i=0;i<length;i++){
            char ch=columnTitle.charAt(i);
            int val=ch-65+1;
            result=result*26+val;
        }
        return result;
    }
}