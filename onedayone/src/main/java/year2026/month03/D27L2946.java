package year2026.month03;

public class D27L2946 {
    public static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k = k % n;
        for (int[] into : mat) {
            for (int j = 0; j < n; j++) {
                int next = (j + k + n) % n;
                if (into[j] != into[next]) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{2, 2}, {2, 2}};
        int k = 1;
        System.out.println(areSimilar(mat, k));
    }
}
