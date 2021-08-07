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

        Knight knight;
        knight = (Knight) boardArray[1][0].getPiece();
        System.out.println("=---=----=---=");
        knight.findValidMoves(board);

        //player test
        Player player1 = new Player(false,true);
    }
}