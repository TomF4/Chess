package com.company.Pieces;

import com.company.Board;
import com.company.Tile;

public class Bishop extends Piece{
    /**
     * @param isWhite is white or not
     */
    public Bishop(boolean isWhite) {
        super(isWhite);
    }
    public Bishop(boolean isWhite,int x,int y){
        super(isWhite, x, y);
    }
    //TODO CHECK WHETHER MOVE IS VALID
    @Override
    public boolean validMove(Board board, Tile start, Tile end) {
        return false;
    }
}
