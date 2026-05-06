package year2026.month04;

import java.util.*;

public class D21L1722 {
    private int[] fa;
    private boolean[] vis;
    private void union(int a, int b) {
        int faA = find(a);
        int faB = find(b);
        if (faA != faB) {
            fa[faA] = faB;
        }
    }

    private int find(int a) {
        if (fa[a] != a) {
            fa[a] = find(fa[a]);
        }
        return fa[a];
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        fa = new int[n];
        vis = new boolean[n];
        for (int[] allowedSwap : allowedSwaps) {
            if(allowedSwap[0] > allowedSwap[1]) {
                int temp = allowedSwap[0];
                allowedSwap[0] = allowedSwap[1];
                allowedSwap[1] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }
        System.out.println("并查集合："+Arrays.toString(fa));
        int res = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> setS = new ArrayList<>();
            List<Integer> setT = new ArrayList<>();
            while (!vis[i]){
                vis[i] = true;
                setS.add(source[i]);
                setT.add(target[i]);
                i = fa[i];
            }
            for (Integer num : setS) {
                if (setT.contains(num)) {
                    setT.remove(num);
                }else {
                    res++;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        D21L1722 d = new D21L1722();
        int[] source = {5,1,2,4,3};
        int[] target = {1,5,4,2,3};
        int[][] allow = {{0,4},{4,2},{1,3},{1,4}};
        System.out.println(d.minimumHammingDistance(source, target, allow));

    }
}
