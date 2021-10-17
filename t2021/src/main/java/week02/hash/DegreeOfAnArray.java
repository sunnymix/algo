package week02.hash;

import common.Print;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode: https://leetcode-cn.com/problems/degree-of-an-array/
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        Print.line(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        Print.line(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, NumStat> map = new HashMap<>();
        int degree = 0, minLength = Integer.MAX_VALUE;

        for (int idx = 0; idx < nums.length; idx++) {
            int num = nums[idx];
            NumStat stat = map.getOrDefault(num, new NumStat());
            stat.count++;
            if (stat.firstIdx == -1) {
                stat.firstIdx = stat.lastIdx = idx;
            } else {
                stat.lastIdx = idx;
            }
            map.put(num, stat);
        }
        for (Map.Entry<Integer, NumStat> entry : map.entrySet()) {
            NumStat stat = entry.getValue();
            if (stat.count > degree || (stat.count == degree && stat.length() < minLength)) {
                degree = stat.count;
                minLength = stat.length();
            }
        }
        return minLength;
    }

    static class NumStat {
        int count = 0, firstIdx = -1, lastIdx = -1;

        int length() {
            return lastIdx - firstIdx + 1;
        }
    }
}
