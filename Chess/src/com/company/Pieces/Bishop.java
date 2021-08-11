package com.company.Pieces;

import com.company.Board.Board;
import com.company.Position;

import java.util.ArrayList;
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
    public List<Position> findValidMoves(Board board) {
        final List<Position> moves = new ArrayList<>();
        Position potentialMove;
        //positive up-right
        for(int i = this.getPos().getX(); i < board.SIZE;i++){
            potentialMove = this.getPos().add(i,i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //negative up-left
        for(int i = this.getPos().getX();i > 0; i--){
            potentialMove = this.getPos().add(-i,i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //positive down-left
        for(int i = this.getPos().getY(); i < board.SIZE;i++){
            potentialMove = this.getPos().add(-i,-i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //negative down
        for(int i = this.getPos().getY();i > 0; i--){
            potentialMove = this.getPos().add(i,-i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        return moves;
    }

    @Override
    public String toString() {
        return "Bishop" + super.toString();
    }
}
