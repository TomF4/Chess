package com.company.Pieces;

import com.company.Board;
import com.company.Position;

import java.util.List;

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

    @Override
    public List<Position> findValidMoves(Board board) {
        return null;
    }

    @Override
    public String toString() {
        return "Pawn" + super.toString();
    }
}