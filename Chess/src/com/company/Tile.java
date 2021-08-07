package com.company;

import com.company.Pieces.Piece;

/*
    Tile class represents a square on the board
    Tiles contain a piece and have a location

    tf 05/08/2021
 */

public class Tile {

    Position m_tilePos = new Position();
    Piece    m_piece;

    public Tile(int x,int y, Piece piece)
    {
        m_tilePos.setX(x);
        m_tilePos.setY(y);
        m_piece = piece;
    }

    public Piece getPiece(){
        return this.m_piece;
    }


    //TODO REMOVE \n
    @Override
    public String toString() {
        return "Tile{" +
                "tilePos=" + m_tilePos +
                "," + m_piece +
                '}'+"\n";
    }
}