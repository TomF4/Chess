package com.company.Pieces;

import com.company.Board;
import com.company.Position;

import java.util.ArrayList;
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


    //TODO is there a better way than 4 for loops
    /**
     * Loops from current pos to find all moves
     * @param board current board
     * @return rook moves
     */
    @Override
    public List<Position> findValidMoves(Board board) {
        final List<Position> moves = new ArrayList<>();
        Position potentialMove;
        //positive right
        for(int i = this.getPos().getX(); i < board.SIZE;i++){
            potentialMove = this.getPos().add(i,0);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //negative left
        for(int i = this.getPos().getX();i > 0; i--){
            potentialMove = this.getPos().add(-i,0);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //positive up
        for(int i = this.getPos().getY(); i < board.SIZE;i++){
            potentialMove = this.getPos().add(0,i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //negative down
        for(int i = this.getPos().getY();i > 0; i--){
            potentialMove = this.getPos().add(0,-i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        return moves;
    }

    @Override
    public String toString() {
        return "Rook" + super.toString();
    }
}
