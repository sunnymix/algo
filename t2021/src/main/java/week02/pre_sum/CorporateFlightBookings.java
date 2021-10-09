package week02.pre_sum;

import common.Print;

/**
 * leetcode: https://leetcode-cn.com/problems/corporate-flight-bookings/
 */
public class CorporateFlightBookings {
    public static void main(String[] args) {
        Print.array(corpFlightBookings(new int[][]{
                {1, 2, 10},
                {2, 2, 15}
        }, 2));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] delta = new int[n + 2];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            delta[first] += seats;
            delta[last + 1] -= seats;
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + delta[i];
        }
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) res[i - 1] = sum[i];
        return res;
    }
}
