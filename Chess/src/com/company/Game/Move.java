package com.company.Game;

import com.company.Board.Tile;
import com.company.Pieces.Piece;

public class Move {

    private Player player;
    private Tile start;
    private Tile end;
    private Piece pieceMoved;
    private Piece pieceEliminated;

    //castling move etc l8

    public Move(Player player,Tile start,Tile end)
    {
        this.player     = player;
        this.start      = start;
        this.end        = end;
        this.pieceMoved = start.getPiece();
    }

    public Player getPlayer(){ return this.player; }
    public Tile   getStart() { return this.start;  }
    public Tile   getEnd()   { return this.end;    }

    public Piece   getPiecedMoved()    { return this.pieceMoved;      }
    public Piece   getPieceEliminated(){ return this.pieceEliminated; }
}