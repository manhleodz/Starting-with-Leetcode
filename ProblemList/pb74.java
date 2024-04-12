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

    public static class pb79 {

        public static boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;

            boolean[][] visited = new boolean[m][n];
            boolean result = false;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        result = backtrack(board, word, visited, i, j, 0);
                        if (result) return true;
                    }
                }
            }

            return false;
        }

        private static boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
            if (index == word.length()) {
                return true;
            }

            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
                return false;
            }

            visited[i][j] = true;

            if (backtrack(board, word, visited, i + 1, j, index + 1) ||
                    backtrack(board, word, visited, i - 1, j, index + 1) ||
                    backtrack(board, word, visited, i, j + 1, index + 1) ||
                    backtrack(board, word, visited, i, j - 1, index + 1)) {
                return true;
            }

            visited[i][j] = false;
            return false;
        }

        public static void main(String[] args) {
            char[][] board = {
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'},
            };

            System.out.println(exist(board, "ABCCED"));
        }
    }
}
