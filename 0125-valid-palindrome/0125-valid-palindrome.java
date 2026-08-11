class Solution {
    public boolean isPalindrome(String s) {
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for(int i=0;i<cleanString.length()/2;i++){
            if(cleanString.charAt(i)!=cleanString.charAt(cleanString.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}