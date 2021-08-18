package com.company.Test;

import com.company.Board.Board;
import com.company.Board.Tile;
import com.company.Pieces.Bishop;
import com.company.Pieces.Pawn;
import com.company.Pieces.Queen;
import com.company.Pieces.Rook;
import com.company.Position;

import java.util.Arrays;

public class ObstructionTests {


    public static void main(String[] args) {
        Tile[][] boardArray;

        System.out.println("=======================");
        System.out.println("=======Board Test======");
        Board board = new Board();
        boardArray  = board.returnArr();
        System.out.println(Arrays.deepToString(boardArray));
        System.out.println("=======================");
        System.out.println("=======================\n");

        Bishop bishop;
        bishop = (Bishop) boardArray[2][7].getPiece();
        bishop.printValidMoves(board);

        Rook rook;
        rook = (Rook) boardArray[0][0].getPiece();
        rook.printValidMoves(board);

        Queen queen;
        queen = (Queen) boardArray[3][0].getPiece();
        queen.printValidMoves(board);

        Pawn pawn;
        pawn = (Pawn) boardArray[1][1].getPiece();
        pawn.printValidMoves(board);

        System.out.println("=======================");
        System.out.println("=====BishopObs Test====");
        System.out.println(bishop.isObstructed(board, bishop.getPos(), new Position(7,2)));
        System.out.println("=======================");
        System.out.println("=======================\n");


        System.out.println("=======================");
        System.out.println("======rookObs Test=====");
        System.out.println(rook.isObstructed(board, rook.getPos(), new Position(0,2)));
        System.out.println("=======================");
        System.out.println("=======================\n");

        System.out.println("=======================");
        System.out.println("=======QueenObs Test======");
        System.out.println(queen.isObstructed(board, queen.getPos(), new Position(1,2)));
        System.out.println("=======================");
        System.out.println("=======================\n");

        System.out.println("=======================");
        System.out.println("=======PawnObs Test======");
        System.out.println(pawn.isObstructed(board, pawn.getPos(), new Position(1,7)));
        System.out.println("=======================");
        System.out.println("=======================\n");
    }
}
