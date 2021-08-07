package com.company.Pieces;

import com.company.Board;
import com.company.Move;
import com.company.Tile;

import java.util.List;

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
    public List<Move> findValidMoves(Board board) {
        return null;
    }


    @Override
    public String toString() {
        return "King" + super.toString();
    }
}
