package com.company.Pieces;

import com.company.Board;
import com.company.Tile;

public class Queen extends Piece{
    /**
     * @param isWhite is white or not
     */
    public Queen(boolean isWhite) {
        super(isWhite);
    }
    public Queen(boolean isWhite,int x,int y){
        super(isWhite, x, y);
    }

    @Override
    public String toString() {
        return "Queen" + super.toString();
    }

}
