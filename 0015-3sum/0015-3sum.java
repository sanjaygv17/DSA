import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array to easily handle duplicates and use two pointers
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the smallest number is positive, 
            // a sum of 0 is impossible with sorted numbers.
            if (nums[i] > 0) {
                break;
            }
            
            // Skip duplicate values for the first element 'i'
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate values for 'left'
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate values for 'right'
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers inward after capturing the valid triplet
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, shift left pointer to get a larger value
                    left++;
                } else {
                    // Sum is too large, shift right pointer to get a smaller value
                    right--;
                }
            }
        }
        
        return result;
    }
}
