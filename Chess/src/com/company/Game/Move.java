package com.company.Game;

import com.company.Board.Tile;
import com.company.Pieces.Piece;

public class Move {

    Player player;
    Tile start;
    Tile end;
    Piece pieceMoved;
    Piece pieceEliminated;

    //castling move etc l8

    public Move(Player player,Tile start,Tile end){
        this.player     = player;
        this.start      = start;
        this.end        = end;
        this.pieceMoved = start.getPiece();
    }
}