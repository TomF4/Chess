package com.company.Pieces;

import com.company.Board.Board;
import com.company.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{



    /**
     * @param isWhite is white or not
     */
    public Pawn(boolean isWhite) {
        super(isWhite);
        setPieceType(PieceType.PAWN);
    }
    public Pawn(boolean isWhite,int x,int y){
        super(isWhite, x, y);
        setPieceType(PieceType.PAWN);
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
    public boolean isObstructed(Board board, Position origin, Position destination) {
        Position differencePosition = destination.subtract(origin);
        int dX = differencePosition.getX();
        int dY = differencePosition.getY();
        //offset so doesn't start from the origin location

        if(dX<0) dX+=1;else if(dX>0) dX-=1;
        if(dY<0) dY+=1;else if(dY>0) dY-=1;

        while(destination.subtract(differencePosition) != origin){
            Position pos;
            pos = board.getTile(destination.subtract(dX,dY)).getTilePos();
            //check to see if the destination tile is occupied by a friend piece before doing anything
            if(board.getTile(destination).getPiece() != null)
                if(board.getTile(destination).getPiece().isSameColour(this)){
                    System.out.println("Destination contains friendly");
                    return true;
                }
            if(isWithinBoard(pos)){
                System.out.println(pos);
                if(pos.getX() == destination.getX() && pos.getY() == destination.getY()){
                    System.out.println("pos == destination");//test line
                    return false;
                }
                if(pos.getX() == origin.getX() && pos.getY() == origin.getY()){
                    System.out.println("pos == origin"); //test line
                    return false;
                }
                if(board.getTile(pos).getPiece() != null){
                    System.out.println("OBSTRUCTION=("+board.getTile(pos).getPiece()+")");//test line
                    System.out.println("ORIGIN=("+origin+")"+"\n" + "DESTINATION=("+destination+")");//test line
                    return true;
                }
            }else
                System.out.println("out"); //just in case somehow not in board

            //trace the path towards the destination properly
            if(destination.getY()>origin.getY()) dY--; else if(destination.getY()<origin.getY()) dY++;
            if(destination.getX()>origin.getX()) dX--; else if(destination.getX()<origin.getX()) dX++;
        }
        return false;
    }
}