package com.company.Pieces;

import com.company.Board;
import com.company.Tile;

public class Knight extends Piece{
    /**
     * @param isWhite is white or not
     */
    public Knight(boolean isWhite) {
        super(isWhite);
    }
    public Knight(boolean isWhite,int x,int y){
        super(isWhite, x, y);
    }
    //TODO CHECK WHETHER MOVE IS VALID
    @Override
    public boolean validMove(Board board, Tile start, Tile end) {
        return false;
    }
}
