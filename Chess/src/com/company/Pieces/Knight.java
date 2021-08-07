package com.company.Pieces;

import com.company.Board;
import com.company.Move;
import com.company.Position;
import com.company.Tile;

import java.util.ArrayList;
import java.util.List;

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
    Position[] knightMoves =
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
    public List<Move> findValidMoves(Board board) {
        final List<Move> moves = new ArrayList<>();
        Position potentialMove;

        for(Position pos: knightMoves){
            potentialMove = Position.add(this.getPos(),pos);
            System.out.println(potentialMove);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Knight" + super.toString();
    }
}
