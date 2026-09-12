import java.util.*;

class Solution {
    private static class Interval {
        int l, r, weight, id;
        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    private static class DPResult {
        long totalWeight;
        List<Integer> indices;

        DPResult(long totalWeight, List<Integer> indices) {
            this.totalWeight = totalWeight;
            this.indices = indices;
        }
    }

    private Interval[] arr;
    private DPResult[][] memo;
    private int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        this.n = intervals.size();
        this.arr = new Interval[n];
        
        for (int i = 0; i < n; i++) {
            List<Integer> inter = intervals.get(i);
            arr[i] = new Interval(inter.get(0), inter.get(1), inter.get(2), i);
        }

        // Sort primarily by start position
        Arrays.sort(arr, (a, b) -> Integer.compare(a.l, b.l));

        this.memo = new DPResult[n][5];
        DPResult finalResult = solve(0, 4);

        // Sort the chosen indices as requested by standard output formatting
        List<Integer> resList = finalResult.indices;
        Collections.sort(resList);
        
        int[] output = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            output[i] = resList.get(i);
        }
        return output;
    }

    private DPResult solve(int idx, int count) {
        if (count == 0 || idx == n) {
            return new DPResult(0, new ArrayList<>());
        }
        if (memo[idx][count] != null) {
            return memo[idx][count];
        }

        // Option 1: Skip current interval
        DPResult skipResult = solve(idx + 1, count);

        // Option 2: Take current interval
        int nextIdx = findNextValid(idx);
        DPResult takeNext = solve(nextIdx, count - 1);
        
        long takeWeight = arr[idx].weight + takeNext.totalWeight;
        List<Integer> takeIndices = new ArrayList<>();
        takeIndices.add(arr[idx].id);
        takeIndices.addAll(takeNext.indices);

        DPResult takeResult = new DPResult(takeWeight, takeIndices);

        // Choose the option that provides the higher weight or tie-breaks lexicographically
        DPResult best;
        if (takeResult.totalWeight > skipResult.totalWeight) {
            best = takeResult;
        } else if (skipResult.totalWeight > takeResult.totalWeight) {
            best = skipResult;
        } else {
            best = getLexicographicallySmaller(takeResult, skipResult);
        }

        memo[idx][count] = best;
        return best;
    }

    // Binary search to find the first interval starting strictly after the current interval ends
    private int findNextValid(int currentIdx) {
        int target = arr[currentIdx].r;
        int low = currentIdx + 1, high = n - 1;
        int ans = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].l > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Tie-breaker utility for matching total weights
    private DPResult getLexicographicallySmaller(DPResult r1, DPResult r2) {
        List<Integer> list1 = new ArrayList<>(r1.indices);
        List<Integer> list2 = new ArrayList<>(r2.indices);
        Collections.sort(list1);
        Collections.sort(list2);

        int len = Math.min(list1.size(), list2.size());
        for (int i = 0; i < len; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return list1.get(i) < list2.get(i) ? r1 : r2;
            }
        }
        return list1.size() <= list2.size() ? r1 : r2;
    }
}
