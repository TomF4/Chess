package com.company.Pieces;

import com.company.Board;
import com.company.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knight extends Piece{

    /**
     * @param isWhite is white or not
     */
    public Knight(boolean isWhite) {
        super(isWhite);
    }
    public Knight(boolean isWhite,int x,int y){
        super(isWhite, x, y);
    }

    //Array of moves eg. when at position (3,3), (-2,-1) will result in a potential move
    private final Position[] knightMoves =
    {       //bot4
            new Position(-2,-1),
            new Position(-1,-2),
            new Position(1,-2),
            new Position(2,-1),
            //top4
            new Position(2,1),
            new Position(1,2),
            new Position(-1,2),
            new Position(-2,1)
    };

    @Override
    public List<Position> findValidMoves(Board board) {
        final List<Position> moves = new ArrayList<>();
        Position potentialMove;

        for(Position pos: knightMoves){
            potentialMove = this.getPos().add(pos);
            if(potentialMove.getY() >= 0 && potentialMove.getX() >= 0 && potentialMove.getX() < 8 && potentialMove.getY() < 8)
                moves.add(potentialMove);
        }
        return moves;
    }

    @Override
    public String toString() {
        return "Knight" + super.toString();
    }
}
