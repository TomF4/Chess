package com.company.Pieces;

import com.company.Board;
import com.company.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    /**
     * Method relies on bishop and rook (findvalidmoves) to function as ive reused the code
     * @param board current board
     * @return list of queen moves
     */
    @Override
    public List<Position> findValidMoves(Board board) {
        List<Position> rookMoves;
        List<Position> bishopMoves;
        final List<Position> queenMoves = new ArrayList<>();

        //create rook and bishop for reuse
        Rook   rook   = new Rook(true);
        Bishop bishop = new Bishop(true);
        //set to this queens position
        rook.setPos(this.getPos().getX(), this.getPos().getY());
        bishop.setPos(this.getPos().getX(), this.getPos().getY());
        //reuse moves from rook and bishop
        rookMoves =  rook.findValidMoves(board);
        bishopMoves =  bishop.findValidMoves(board);
        //add mvoes to queen moves
        queenMoves.addAll(rookMoves);
        queenMoves.addAll(bishopMoves);
        return queenMoves;
    }

    @Override
    public String toString() {
        return "Queen" + super.toString();
    }
}