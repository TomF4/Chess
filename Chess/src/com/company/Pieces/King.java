package com.company.Pieces;

import com.company.Board;
import com.company.Tile;

public class King extends Piece{

    /**
     * @param isWhite is white or not
     */
    public King(boolean isWhite) {
        super(isWhite);
    }
    public King(boolean isWhite,int x,int y){
        super(isWhite, x, y);
    }


    @Override
    public String toString() {
        return "King" + super.toString();
    }
}
