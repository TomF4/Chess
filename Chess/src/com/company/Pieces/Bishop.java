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
    public ArrayList<Position> findValidMoves(Board board) {
        final ArrayList<Position> moves = new ArrayList<>();
        Position potentialMove;
        //positive up-right
        for(int i = 1; i < Board.SIZE; i++){
            potentialMove = this.getPos().add(i,i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //negative up-left
        for(int i = 1; i < Board.SIZE; i++){
            potentialMove = this.getPos().add(-i,i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //positive down-left
        for(int i = 1; i < Board.SIZE; i++){
            potentialMove = this.getPos().add(-i,-i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        //negative down
        for(int i = 1; i < Board.SIZE; i++){
            potentialMove = this.getPos().add(i,-i);
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        return moves;
    }

    /**
     * Finds the obstruction on the board by finding the difference between the two points and
     * tracing the path between points to find any obstructions
     * @param board current board
     * @param origin the pos of the piece being moved
     * @param destination the destination of the piece being moves
     * @return returns true if piece is blocked
     */
    @Override
    public boolean isObstructed(Board board, Position origin, Position destination) {
        Position differencePosition = destination.subtract(origin);
        int dX = differencePosition.getX();
        int dY = differencePosition.getY();
        //offset so doesn't start from the origin location
        if(dX<0) dX+=1; else dX-=1;
        if(dY<0) dY+=1; else dY-=1;

        while(destination.subtract(differencePosition) != origin){
            Position pos;
            pos = board.getTile(destination.subtract(dX,dY)).getTilePos();

            if(board.getTile(destination).getPiece() != null)
                if(board.getTile(destination).getPiece().isSameColour(this)){
                    System.out.println("Destination contains friendly");
                    return true;
                }
            if(isWithinBoard(pos)){
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
            if(destination.getY()>origin.getY())
                dY--;
            else if(destination.getY()<origin.getY())
                dY++;
            if(destination.getX()>origin.getX())
                dX--;
            else if(destination.getX()<origin.getX())
                dX++;
        }
        return false;
    }
}