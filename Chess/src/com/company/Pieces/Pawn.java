package com.company.Pieces;

import com.company.Board;
import com.company.Position;

import java.util.ArrayList;
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

    public Position[] pawnMoves =
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
            potentialMove = Position.add(this.getPos(),pos);
            if(potentialMove.getY() >= 0 && potentialMove.getX() >= 0) { //within board
                if(this.isWhite() && pos.getY() > 0)
                    moves.add(potentialMove);
                else if(!this.isWhite() && pos.getY() < 0)
                    moves.add(potentialMove);
            }
            System.out.println("All moves" + potentialMove);
        }
        System.out.println("Possible Moves" + moves.toString());
        return moves;
    }

    @Override
    public String toString() {
        return "Pawn" + super.toString();
    }
}