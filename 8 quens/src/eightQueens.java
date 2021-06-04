

public class eightQueens {

public static void main(String[] args) { int n = 8; Queens(n); }

private static void Queens(int noOfQueens) {
    int [] board = new int[noOfQueens];
    placeQ(board, 0, noOfQueens);
}

private static void placeQ(int[] board, int current, int noOfQ) {
    if (current == noOfQ) {
        displayQueens(board);
        return;
    }

    for (int i = 0; i < noOfQ; i++) {
        board[current] = i;
        if (noKill(board, current)) {
            placeQ(board, current + 1, noOfQ);
        }
    }
}
private static boolean noKill(int[] board, int currentColumnOfQueen) {

    for (int i = 0; i < currentColumnOfQueen; i++) {
        if (board[i] == board[currentColumnOfQueen])
            return false;
        if ((currentColumnOfQueen - i) == Math.abs(board[currentColumnOfQueen] - board[i])) {
            return false;
        }
    }
    return true;
}

private static void displayQueens(int[] board) {
    System.out.print("\n");

    for (int value : board)
        System.out.printf(value + "%3s" ," ");

    System.out.print("\n\n");

    int n = board.length;

    for (int i = 0; i < n; i++) {
        for (int value : board) {
            if (value == i)
                System.out.print("Q\t");
            else
                System.out.print("*\t");
        }
        System.out.print("\n");
    }
}

}
