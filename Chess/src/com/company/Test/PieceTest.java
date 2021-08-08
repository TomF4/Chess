package com.company.Test;


import com.company.Board;
import com.company.Pieces.*;
import com.company.Player;
import com.company.Tile;

import java.util.Arrays;

public class PieceTest {

    public static void main(String[] args) {

        Tile[][] boardArray;

        System.out.println("=======================");
        System.out.println("=======Pawn Test=======");
        Pawn pawn1 = new Pawn(false);
        pawn1.setPos(2,3);
        System.out.println("Black Pawn Test = "+pawn1);

        Pawn pawn2 = new Pawn(true);
        pawn2.setPos(4,4);
        System.out.println("White Pawn Test = "+pawn2);
        System.out.println("=======================");
        System.out.println("=======================\n");

        System.out.println("=======================");
        System.out.println("=======Board Test======");
        Board board = new Board();
        boardArray  = board.returnArr();
        System.out.println(Arrays.deepToString(boardArray));
        System.out.println("=======================");
        System.out.println("=======================\n");


        System.out.println("=======================");
        System.out.println("=======Knight Test======");
        Knight knight;
        knight = (Knight) boardArray[1][0].getPiece();
        knight.findValidMoves(board);
        System.out.println("=======================");
        System.out.println("=======================\n");

        System.out.println("=======================");
        System.out.println("=======Pawn Test======");
        Pawn pawn;
        pawn = (Pawn) boardArray[1][1].getPiece();
        pawn.findValidMoves(board);
        System.out.println("=======================");
        System.out.println("=======================\n");

        System.out.println("=======================");
        System.out.println("=======Rook Test======");
        Rook rook;
        rook = (Rook) boardArray[7][7].getPiece();
        rook.findValidMoves(board);
        System.out.println("=======================");
        System.out.println("=======================\n");

        System.out.println("=======================");
        System.out.println("=======Bishop Test======");
        Bishop bishop;
        bishop = (Bishop) boardArray[2][0].getPiece();
        bishop.findValidMoves(board);
        System.out.println("=======================");
        System.out.println("=======================\n");

        System.out.println("=======================");
        System.out.println("=======Queen Test======");
        Queen queen;
        queen = (Queen) boardArray[3][0].getPiece();
        queen.findValidMoves(board);
        System.out.println("=======================");
        System.out.println("=======================\n");

        //player test
        Player player1 = new Player(false,true);
    }
}