class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        
        int[][] sortedStarts = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedStarts[i][0] = intervals[i][0];
            sortedStarts[i][1] = i;
        }
        
        Arrays.sort(sortedStarts, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < n; i++) {
            int targetEnd = intervals[i][1];
            
            int left = 0, right = n - 1;
            int foundIndex = -1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (sortedStarts[mid][0] >= targetEnd) {
                    foundIndex = sortedStarts[mid][1]; 
                    right = mid - 1; 
                } else {
                    left = mid + 1; 
                }
            }
            
            result[i] = foundIndex;
        }
        
        return result;
    }
}
