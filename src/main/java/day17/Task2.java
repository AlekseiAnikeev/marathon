package day17;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        ChessPiece[][] chessPiece = new ChessPiece[8][8];
        for (ChessPiece[] chessPieces : chessPiece) {
            Arrays.fill(chessPieces, ChessPiece.EMPTY);
        }
        addChessPieces(chessPiece);
        ChessBoard chessBoard = new ChessBoard(chessPiece);
//        ChessBoard chessBoard = new ChessBoard(new ChessPiece[][]{
//                {ChessPiece.ROOK_BLACK, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.ROOK_BLACK, ChessPiece.KING_BLACK, ChessPiece.EMPTY},
//                {ChessPiece.EMPTY, ChessPiece.ROOK_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.PAWN_BLACK, ChessPiece.PAWN_BLACK, ChessPiece.EMPTY, ChessPiece.PAWN_BLACK},
//                {ChessPiece.PAWN_BLACK, ChessPiece.EMPTY, ChessPiece.KNIGHT_BLACK, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.PAWN_BLACK, ChessPiece.EMPTY},
//                {ChessPiece.QUEEN_BLACK, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.BISHOP_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY},
//                {ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.BISHOP_BLACK, ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY},
//                {ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.BISHOP_WHITE, ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY},
//                {ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.QUEEN_WHITE, ChessPiece.EMPTY, ChessPiece.PAWN_WHITE, ChessPiece.EMPTY, ChessPiece.PAWN_WHITE},
//                {ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.EMPTY, ChessPiece.ROOK_WHITE, ChessPiece.KING_WHITE, ChessPiece.EMPTY},
//        });
        chessBoard.print();
    }

    public static void addChessPieces(ChessPiece[][] chessPiece) { //Тут можно реализовать ввод с клавиатуры по координатам, с выбором фигур;
        chessPiece[0][0] = ChessPiece.ROOK_BLACK;
        chessPiece[0][5] = ChessPiece.ROOK_BLACK;
        chessPiece[0][6] = ChessPiece.KING_BLACK;
        chessPiece[1][1] = ChessPiece.ROOK_WHITE;
        chessPiece[1][4] = ChessPiece.PAWN_BLACK;
        chessPiece[1][5] = ChessPiece.PAWN_BLACK;
        chessPiece[1][7] = ChessPiece.PAWN_BLACK;
        chessPiece[2][0] = ChessPiece.PAWN_BLACK;
        chessPiece[2][2] = ChessPiece.KNIGHT_BLACK;
        chessPiece[2][6] = ChessPiece.PAWN_BLACK;
        chessPiece[3][0] = ChessPiece.QUEEN_BLACK;
        chessPiece[3][3] = ChessPiece.BISHOP_WHITE;
        chessPiece[4][3] = ChessPiece.BISHOP_BLACK;
        chessPiece[4][4] = ChessPiece.PAWN_WHITE;
        chessPiece[5][4] = ChessPiece.BISHOP_WHITE;
        chessPiece[5][5] = ChessPiece.PAWN_WHITE;
        chessPiece[6][0] = ChessPiece.PAWN_WHITE;
        chessPiece[6][3] = ChessPiece.QUEEN_WHITE;
        chessPiece[6][5] = ChessPiece.PAWN_WHITE;
        chessPiece[6][7] = ChessPiece.PAWN_WHITE;
        chessPiece[7][5] = ChessPiece.ROOK_WHITE;
        chessPiece[7][6] = ChessPiece.KING_WHITE;
    }
}
