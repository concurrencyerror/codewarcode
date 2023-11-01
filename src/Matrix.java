public class Matrix {
    public static int[][] matrixMultiplication(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = reduceNum(a[i], b, j);
            }
        }
        return result;
    }

    private static int reduceNum(int[] a, int[][] b, int l) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result = result + a[i] * b[i][l];
        }
        return result;
    }
}
