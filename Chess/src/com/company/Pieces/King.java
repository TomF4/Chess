package com.company.Pieces;

import com.company.Board;
import com.company.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    private final Position[] kingMoves = {
            new Position(0,1),      //up
            new Position(1,0),      //right
            new Position(-1,0),     //left
            new Position(0,-1),     //down
            new Position(1,1),      //upright
            new Position(-1,1),     //upleft
            new Position(1,-1),     //downright
            new Position(-1,-1),    //downleft
    };


    /**
     * @param isWhite is white or not
     */
    public King(boolean isWhite) {
        super(isWhite);
    }
    public King(boolean isWhite,int x,int y){
        super(isWhite, x, y);
    }

    @Override
    public List<Position> findValidMoves(Board board) {
        final List<Position> moves = new ArrayList<>();
        Position potentialMove;

        for(Position pos: this.kingMoves){
            potentialMove = this.getPos().add(pos);
            if(isWithinBoard(potentialMove)) { //within board
                moves.add(potentialMove);
            }
        }
        return moves;
    }


    @Override
    public String toString() {
        return "King" + super.toString();
    }
}
