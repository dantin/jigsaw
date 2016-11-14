public class ValidSudoku {
    private static final String LINE = "+---------+---------+---------+";
    private static final int SIZE = 10;

    public boolean isValidSudoku(char[][] board) {
        int[] hash = null;
        for(int i = 0; i < board.length; i++) {
            hash = new int[SIZE];
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] >= '1' && board[i][j] <= '9') {
                    hash[board[i][j] - '0']++;
                } else if(board[i][j] == '.') {
                    continue;
                } else {
                    return false;
                }
            }
            if(!isValidGrid(hash)) return false;
        }
        for(int i = 0; i < board.length; i++) {
            hash = new int[SIZE];
            for(int j = 0; j < board[i].length; j++) {
                if(board[j][i] >= '1' && board[j][i] <= '9') {
                    hash[board[j][i] - '0']++;
                } else if(board[j][i] == '.') {
                    continue;
                } else {
                    return false;
                }
            }
            if(!isValidGrid(hash)) return false;
        }
        for(int k = 0; k < 9; k++) {
            hash = new int[SIZE];
            for(int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {
                
                for(int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
                    // System.out.printf("(%d, %d)\n", i, j);
                    if(board[i][j] >= '1' && board[i][j] <= '9') {
                        hash[board[i][j] - '0']++;
                    } else if(board[i][j] == '.') {
                        continue;
                    } else {
                        return false;
                    }
                }
                
            }
            if(!isValidGrid(hash)) return false;
        }
        
        return true;
    }

    private boolean isValidGrid(int[] grid) {
        for(int i = 0; i < grid.length; i++) {
            if(grid[i] > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            "....5..1.".toCharArray(),
            ".4.3.....".toCharArray(),
            ".....3..1".toCharArray(),
            "8......2.".toCharArray(),
            "..2.7....".toCharArray(),
            ".15......".toCharArray(),
            ".....2...".toCharArray(),
            ".2.9.....".toCharArray(),
            "..4......".toCharArray()
        };
        drawBoard(board);

        ValidSudoku solution = new ValidSudoku();
        System.out.printf("%s board\n", solution.isValidSudoku(board) ? "Valid" : "Invalid");
    }

    private static void drawBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) {
                System.out.println(LINE);
            }
            for (int j = 0; j < board[i].length; j++) {
                if (j % 3 == 0) {

                    System.out.print("|");
                }
                System.out.printf(" %c ", board[i][j]);
            }

            System.out.println("|");

        }
        System.out.println(LINE);
    }
}