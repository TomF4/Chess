package com.company.Pieces;

import com.company.Board.Board;
import com.company.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

    /**
     * @param isWhite is white or not
     */
    public Rook(boolean isWhite) {
        super(isWhite);
        setPieceType(PieceType.ROOK);
    }
    public Rook(boolean isWhite,int x,int y){
        super(isWhite, x, y);
        setPieceType(PieceType.ROOK);
    }

    /**
     * Loops from current pos to find all moves
     * feels like a better way to do this exits
     * @param board current board
     * @return rook moves
     */
    @Override
    public List<Position> findValidMoves(Board board) {
        final List<Position> moves = new ArrayList<>();
        Position potentialMove;
        for(int i = 1; i < board.SIZE;i++){
            potentialMove = this.getPos().add(i,0);  //positive right
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        for(int i = 1; i < board.SIZE;i++){
            potentialMove = this.getPos().add(-i,0); //negative left
                if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        for(int i = 1; i < board.SIZE;i++){
            potentialMove = this.getPos().add(0,i);  //positive up
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        for(int i = 1; i < board.SIZE;i++){
            potentialMove = this.getPos().add(0,-i); //negative down
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        return moves;
    }
}

/*
        //negative left
       // int x = 0;
        //for(int i = this.getPos().getX();i > 0; i--){
        //    potentialMove = this.getPos().add(-i,0);
        //    if(isWithinBoard(potentialMove))
        //        moves.add(potentialMove);
        //}
 */