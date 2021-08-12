package com.company.Board;

import com.company.Pieces.Piece;
import com.company.Position;

/*
    Tile class represents a square on the board
    Tiles contain a piece and have a location

    tf 05/08/2021
 */

public class Tile
{

    Position tilePos = new Position();
    Piece piece;

    public Tile(int x,int y, Piece piece)
    {
        tilePos.setX(x);
        tilePos.setY(y);
        this.piece = piece;
    }

    public Piece getPiece(){
        return this.piece;
    }

    //TODO REMOVE \n
    @Override
    public String toString() {
        return "Tile{" +
                "tilePos=" + tilePos +
                "," + piece +
                '}'+"\n";
    }
}