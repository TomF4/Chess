package com.company.Pieces;

import com.company.Board;
import com.company.Move;
import com.company.Tile;

import java.util.List;

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

    @Override
    public List<Move> findValidMoves(Board board) {
        return null;
    }

    @Override
    public String toString() {
        return "Bishop" + super.toString();
    }
}
