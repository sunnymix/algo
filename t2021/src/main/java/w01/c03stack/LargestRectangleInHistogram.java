package w01.c03stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * leetcode: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    /**
     * 【思路】
     * 1. 问题分解：
     * 求面积，则基本元素有宽度和高度；
     * 矩形必然跟某根柱子的顶边对齐，然后以这根柱子向两边扩展，直到第一个比它矮的柱子；
     * 因此最多有N种矩形的情况，在每种情况中，最矮的柱子的高度是限制矩形面积的瓶颈。
     * <p>
     * 2. 单调递增性分析：
     * TODO
     *
     * @param heights 每根柱子的高度值（柱子等宽）
     * @return 最大面积
     */
    public static int largestRectangleArea(int[] heights) {
        heights = pushZero(heights);
        Stack<Rect> rects = new Stack<>();
        int res = 0;
        for (int height : heights) {
            int extendWidth = 0;
            // 1. 操作栈顶，满足单调性
            while (!rects.isEmpty() && height < rects.peek().height) {
                // 破坏了单调性，确定了栈顶高度的扩展范围，需要删除栈顶
                extendWidth += rects.peek().width;
                res = Math.max(res, rects.peek().height * extendWidth);
                rects.pop();
            }
            // 2. 入栈，只贡献宽度，不贡献高度（因为单调递增，当前柱子的高度是最高的）
            rects.push(new Rect(extendWidth + 1, height));
        }
        return res;
    }

    private static int[] pushZero(int[] heights) {
        int[] hs = Arrays.copyOf(heights, heights.length + 1);
        hs[hs.length - 1] = 0;
        return hs;
    }

    private static class Rect {
        int width;
        int height;

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
