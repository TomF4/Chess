package com.company.Test;

import com.company.Board;
import com.company.Pieces.Pawn;
import com.company.Tile;
import org.w3c.dom.ls.LSOutput;

public class PawnTest {

    public static void main(String[] args) {

        Tile[][] testArray;

        System.out.println("==============================");
        System.out.println("=============Test=============");
        Board board = new Board();
        testArray = board.returnArr();
        Pawn testPawn0;
        testPawn0 = (Pawn) testArray[1][1].getPiece();
        System.out.println(testPawn0);

        for (int i = 0; i < 4; i++) {
            System.out.println(i);
        }
    }
}