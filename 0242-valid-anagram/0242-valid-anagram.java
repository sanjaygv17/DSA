class Solution {
    public boolean isAnagram(String s, String t) {
        s=s.replaceAll("\\s","").toLowerCase();
        t=t.replaceAll("\\s","").toLowerCase();
        char[] S=s.toCharArray();
        char[] T=t.toCharArray();
        if(S.length != T.length) return false;
        Arrays.sort(S);
        Arrays.sort(T);
        return Arrays.equals(S,T);
    }
}