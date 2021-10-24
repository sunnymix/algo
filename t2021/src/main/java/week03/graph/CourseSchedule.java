package week03.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode: https://leetcode-cn.com/problems/course-schedule/
 */
public class CourseSchedule {

    List<List<Integer>> toEdges;
    int[] inDeg;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        toEdges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            toEdges.add(new ArrayList<>());
        }
        inDeg = new int[numCourses];
        for (int[] pre : prerequisites) {
            int ai = pre[0];
            int bi = pre[1];
            toEdges.get(bi).add(ai);
            inDeg[ai]++;
        }
        // 第一步：从零度出发
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> learned = new ArrayList<>();
        while (!q.isEmpty()) {
            int x = q.poll();
            learned.add(x);
            // 第二步：扩展一个点，周围的入度减一
            for (int y : toEdges.get(x)) {
                inDeg[y]--;
                // 第三步：入度减为0，表示可以入队学习了
                if (inDeg[y] == 0) {
                    q.add(y);
                }
            }
        }
        return learned.size() == numCourses;
    }
}
