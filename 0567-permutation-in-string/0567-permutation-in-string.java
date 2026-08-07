class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];
        
        for (int i = 0; i < len1; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }
        
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Counts[i] == s2Counts[i]) {
                matches++;
            }
        }
        
        for (int i = 0; i < len2 - len1; i++) {
            if (matches == 26) {
                return true;
            }
            
            int r = s2.charAt(i + len1) - 'a';
            s2Counts[r]++;
            if (s2Counts[r] == s1Counts[r]) {
                matches++;
            } else if (s2Counts[r] == s1Counts[r] + 1) {
                matches--;
            }
            
            int l = s2.charAt(i) - 'a';
            s2Counts[l]--;
            if (s2Counts[l] == s1Counts[l]) {
                matches++;
            } else if (s2Counts[l] == s1Counts[l] - 1) {
                matches--;
            }
        }
        
        return matches == 26;
    }
}
