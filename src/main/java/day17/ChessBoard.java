package day17;

public class ChessBoard {
    private ChessPiece[][] board;
    public ChessBoard(ChessPiece[][] board) {
        this.board = board;
    }

    public void print() {
        for (ChessPiece[] chessPieces : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(chessPieces[j].getChessName());
            }
            System.out.println();
        }
    }
}
