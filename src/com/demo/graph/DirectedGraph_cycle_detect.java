package com.demo.graph;

import java.util.ArrayList;

public class DirectedGraph_cycle_detect {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 3};
        int[] b = new int[]{2, 3, 3, 4, 5};

        System.out.println(solution(a, b));
    }

    public static boolean solution(int[] A, int[] B) {
        int[] vis = new int[A.length + 1];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= A.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            adj.get(A[i]).add(B[i]);
        }
        return dfs(A[0], adj, vis, 0, A.length);
    }

    private static boolean dfs(int curr, ArrayList<ArrayList<Integer>> adj, int[] vis, int size, int n) {
        if (vis[curr] == 1) {
            if (size == n) return true;
            else {
                vis[curr] = 2;
                return false;
            }
        }
        if (vis[curr] == 2) return false;

        vis[curr] = 1;

        ArrayList<Integer> a = adj.get(curr);

        for (int x : a) {
            if (dfs(x, adj, vis, size + 1, n)) return true;
        }
        vis[curr] = 2;
        return false;
    }
}