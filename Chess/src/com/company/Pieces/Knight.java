package com.company.Pieces;

import com.company.Board.Board;
import com.company.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{



    /**
     * @param isWhite is white or not
     */
    public Knight(boolean isWhite) {
        super(isWhite);
        setPieceType(PieceType.KNIGHT);
    }
    public Knight(boolean isWhite,int x,int y){
        super(isWhite, x, y);
        setPieceType(PieceType.KNIGHT);
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
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        return moves;
    }
}
