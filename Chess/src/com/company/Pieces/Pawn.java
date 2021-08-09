package com.company.Pieces;

import com.company.Board;
import com.company.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private final Position[] pawnMoves =
    {
            new Position(0,2),  //Moves
            new Position(0,-2), //Moves
            new Position(0,1),  //Moves
            new Position(0,-1), //Moves
            new Position(-1,1), //Attack
            new Position(1,1)   //Attack
    };

    /**
     * Pawns can only move forward atm. (no special moves)
     * @param board current board
     * @return list of moves for pawns
     */
    @Override
    public List<Position> findValidMoves(Board board) {
        final List<Position> moves = new ArrayList<>();
        Position potentialMove;

        for(Position pos: pawnMoves){
            potentialMove = this.getPos().add(pos);
            if(isWithinBoard(potentialMove)) { //within board
                if(this.isWhite() && pos.getY() > 0)
                    moves.add(potentialMove);
                else if(!this.isWhite() && pos.getY() < 0)
                    moves.add(potentialMove);
            }
        }
        return moves;
    }

    @Override
    public String toString() {
        return "Pawn" + super.toString();
    }
}