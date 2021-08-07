package com.company.Pieces;

import com.company.Board;
import com.company.Position;

import java.util.List;

public class Rook extends Piece{

    /**
     * @param isWhite is white or not
     */
    public Rook(boolean isWhite) {
        super(isWhite);
    }
    public Rook(boolean isWhite,int x,int y){
        super(isWhite, x, y);
    }

    @Override
    public List<Position> findValidMoves(Board board) {
        return null;
    }

    @Override
    public String toString() {
        return "Rook" + super.toString();
    }
}
