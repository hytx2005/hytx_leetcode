package a10huisu;

public class T06L79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = backTrack(board, word, i + 1, j, index + 1) ||
                        backTrack(board, word, i - 1, j, index + 1) ||
                        backTrack(board, word, i, j + 1, index + 1) ||
                        backTrack(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return found;
    }

    public static void main(String[] args) {
        T06L79 solution = new T06L79();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        System.out.println(solution.exist(board, word2));
    }
}
