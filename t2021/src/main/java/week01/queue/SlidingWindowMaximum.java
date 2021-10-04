package week01.queue;

import common.Print;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * leetcode: https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Print.array(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 结果数组
        List<Integer> res = new ArrayList<>();
        // 双端队列：存储下标；队尾进，队头出
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 从队头删除出界的元素
            while (!q.isEmpty() && q.peekFirst() <= i - k) q.pollFirst();
            // 从队尾删除破坏单调性的元素
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();
            // 从队尾添加新元素
            q.addLast(i);
            // 取队头更新答案
            if (i >= k - 1) {
                res.add(nums[q.peekFirst()]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
