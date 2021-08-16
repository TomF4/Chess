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
        setPieceType(PieceType.BISHOP);
    }
    public Bishop(boolean isWhite,int x,int y){
        super(isWhite, x, y);
        setPieceType(PieceType.BISHOP);
    }

    @Override
    public List<Position> findValidMoves(Board board) {
        final List<Position> moves = new ArrayList<>();
        Position potentialMove;
        //positive up-right
        for(int i = 0; i < board.SIZE;i++){
            potentialMove = this.getPos().add(i,i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //negative up-left
        for(int i = 0; i < board.SIZE;i++){
            potentialMove = this.getPos().add(-i,i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //positive down-left
        for(int i = 0; i < board.SIZE;i++){
            potentialMove = this.getPos().add(-i,-i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //negative down
        for(int i = 0; i < board.SIZE;i++){
            potentialMove = this.getPos().add(i,-i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        return moves;
    }



}
