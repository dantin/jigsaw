public class BattleshipsInABoard {

    public int countBattleships(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        int count = 0;
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(board[row][column] == 'X') {
                    if(row > 0 && board[row - 1][column] == 'X') continue;
                    if(column > 0 && board[row][column - 1] == 'X') continue;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            "X..X".toCharArray(),
            "...X".toCharArray(),
            "...X".toCharArray()
        };

        for(char[] row : board) {
            System.out.println(new String(row));
        }
        BattleshipsInABoard solution = new BattleshipsInABoard();
        int count = solution.countBattleships(board);
        System.out.printf("%d ship(s)\n", count);
    }
}