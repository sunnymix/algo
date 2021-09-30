package w01.c03stack;

import java.util.Stack;

/**
 * leetcode: https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    public static int trap(int[] heights) {
        int res = 0;
        Stack<Rect> stk = new Stack<>();
        for (int height : heights) {
            int extendWidth = 0;
            while (!stk.isEmpty() && stk.peek().height <= height) {
                int bottom = stk.peek().height;
                extendWidth += stk.peek().width;
                stk.pop();
                if (stk.isEmpty()) continue;
                int up = Math.min(height, stk.peek().height);
                res += extendWidth * (up - bottom);
            }
            stk.push(new Rect(extendWidth + 1, height));
        }
        return res;
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
