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
    public ArrayList<Position> findValidMoves(Board board) {
        final ArrayList<Position> moves = new ArrayList<>();
        Position potentialMove;
        for(int i = 1; i < Board.SIZE; i++){
            potentialMove = this.getPos().add(i,0);  //positive right
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        for(int i = 1; i < Board.SIZE; i++){
            potentialMove = this.getPos().add(-i,0); //negative left
                if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        for(int i = 1; i < Board.SIZE; i++){
            potentialMove = this.getPos().add(0,i);  //positive up
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        for(int i = 1; i < Board.SIZE; i++){
            potentialMove = this.getPos().add(0,-i); //negative down
            if(isWithinBoard(potentialMove))
                moves.add(potentialMove);
        }
        return moves;
    }

    /**
     *
     * @param board current board
     * @param origin origin pos
     * @param destination destination pos
     * @return
     */
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

/*
        //negative left
       // int x = 0;
        //for(int i = this.getPos().getX();i > 0; i--){
        //    potentialMove = this.getPos().add(-i,0);
        //    if(isWithinBoard(potentialMove))
        //        moves.add(potentialMove);
        //}
 */