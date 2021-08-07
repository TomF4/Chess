package com.company.Pieces;

import com.company.Board;
import com.company.Tile;

public class Pawn extends Piece{

    /**
     * @param isWhite is white or not
     */
    public Pawn(boolean isWhite) {
        super(isWhite);
    }
    public Pawn(boolean isWhite,int x,int y){
        super(isWhite, x, y);
    }

    
    //TODO CHECK WHETHER MOVE IS VALID
    @Override
    public boolean validMove(Board board, Tile start, Tile end) {

        if(this.isWhite() && end.getPiece().isWhite())
            return false;
        //pawn can only move fowards (white)
        if(this.isWhite() && end.getPiece().getPos().getY() < start.getPiece().getPos().getY())
            return false;
        //pawn can only move fowards (black)
        if(!this.isWhite() && end.getPiece().getPos().getY() > start.getPiece().getPos().getY())
            return false;
        //if greater than the current board size return false.
       //if(
       //        start.getPiece().getPos().getY() > board.getBoardSize() &&
       //        start.getPiece().getPos().getX() > board.getBoardSize() &&
       //        end.getPiece().getPos().getX() > board.getBoardSize() && end.getPiece().getPos().getY() > board.getBoardSize()
       //) return false;

        //if passed everything return true.
        return true;
    }


    @Override
    public String toString() {
        return "Pawn" + super.toString();
    }
}