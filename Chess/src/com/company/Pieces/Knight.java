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
    public ArrayList<Position> findValidMoves(Board board) {
        final ArrayList<Position> moves = new ArrayList<>();
        Position potentialMove;

        for(Position pos: knightMoves){
            potentialMove = this.getPos().add(pos);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        return moves;
    }

    /**
     * piece cant be obstructed
     * @param board current board
     * @param origin origin pos
     * @param destination destination pos
     * @return will always return false for knight
     */
    @Override
    public boolean isObstructed(Board board, Position origin, Position destination) {
        if(board.getTile(destination).getPiece() != null)
            if(board.getTile(destination).getPiece().isSameColour(this)){
                System.out.println("Destination contains friendly");
                return true;
            }
        return false;
    }


}