package leetcode.medium;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7) == 28);
        System.out.println(uniquePaths.uniquePaths(3, 2) == 3);
        System.out.println(uniquePaths.uniquePaths(7, 3) == 28);
        System.out.println(uniquePaths.uniquePaths(3, 3) == 6);

    }

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        //오른쪽와 아래로만 갈수 있어서 가장 자리 위 아래 값을 1로 채운다

        // 아래 값을 1로 채움
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }

        // 오른쪽 값을 1로 채움
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //자신의 위쪽과 왼쪽값을 더한값으로 채움
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }        

        return matrix[m-1][n-1];
    }
}
