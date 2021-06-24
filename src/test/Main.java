package test;


public class Main {
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] matrix11 = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix11[j][i] = matrix[i][j];
            }
        }
        return matrix11;
    }

    public static void main(String[] args) {

    }
}