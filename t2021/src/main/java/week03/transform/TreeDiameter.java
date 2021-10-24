package week03.transform;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode: https://leetcode-cn.com/problems/tree-diameter/
 */
public class TreeDiameter {
    public int treeDiameter(int[][] edges) {
        this.edges = edges;
        _initToEdges();
        int farthestPoint1 = _findFarthest(0).point;
        return _findFarthest(farthestPoint1).distance;
    }

    private int n;
    private int[][] edges;
    private List<List<Integer>> toEdges;

    private void _initToEdges() {
        toEdges = new ArrayList<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            n = Math.max(n, Math.max(x, y));
        }
        n++;
        for (int i = 0; i < n; i++) {
            toEdges.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            toEdges.get(x).add(y);
            toEdges.get(y).add(x);
        }
    }

    private static class PointAndDistance {
        int point, distance;

        public PointAndDistance(int point, int distance) {
            this.point = point;
            this.distance = distance;
        }
    }

    private PointAndDistance _findFarthest(int start) {
        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            depth[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        depth[start] = 0;
        while (!q.isEmpty()) {
            int head = q.poll();
            for (int toEdge : toEdges.get(head)) {
                if (depth[toEdge] != -1) {
                    continue;
                }
                depth[toEdge] = depth[head] + 1;
                q.add(toEdge);
            }
        }
        int ans = start;
        for (int i = 0; i < n; i++) {
            if (depth[i] > depth[ans]) {
                ans = i;
            }
        }
        return new PointAndDistance(ans, depth[ans]);
    }
}
