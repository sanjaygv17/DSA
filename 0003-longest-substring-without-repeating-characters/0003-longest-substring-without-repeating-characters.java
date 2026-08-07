class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character , Integer> map=new HashMap<>();
        int left=0;
        int maxLength=0;

        for(int right=0;right<s.length();right++){
            char character=s.charAt(right);

        if(map.containsKey(character)){
            left=Math.max(left,map.get(character)+1);
        }

        map.put(character,right);
        maxLength=Math.max(maxLength,right-left+1);
        }

        return maxLength;
    }
}