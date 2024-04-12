package ProblemList;

public class pb74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int lengthY = matrix.length;
        int lengthX = matrix[0].length;
        int start = matrix[0][0];
        int end = matrix[lengthY - 1][lengthX - 1];

        if (target < start || target > end) return false;

        if (target < matrix[lengthY / 2][0]) {
            for (int i = 0; i < lengthY / 2; i++) {
                for (int j = 0; j < lengthX; j++) {
                    if (target == matrix[i][j]) return true;
                }
            }
        } else if (target > matrix[lengthY / 2][0]) {
            for (int i = lengthY / 2; i < lengthY; i++) {
                for (int j = 0; j < lengthX; j++) {
                    if (target == matrix[i][j]) return true;
                }
            }
        } else return true;

        return false;
    }

    public static void main(String[] args) {
        pb74 result = new pb74();
        System.out.println(result.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 13));
    }
}
