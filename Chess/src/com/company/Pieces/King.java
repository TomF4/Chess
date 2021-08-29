package com.company.Pieces;

import com.company.Board.Board;
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
        setPieceType(PieceType.KING);
    }
    public King(boolean isWhite,int x,int y){
        super(isWhite, x, y);
        setPieceType(PieceType.KING);
    }

    @Override
    public ArrayList<Position> findValidMoves(Board board) {
        final ArrayList<Position> moves = new ArrayList<>();
        Position potentialMove;

        for(Position pos: this.kingMoves){
            potentialMove = this.getPos().add(pos);
            if(isWithinBoard(potentialMove))  //within board
                moves.add(potentialMove);
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
                    System.out.println("pos == origin"); //test lined
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


    //TODO Check check all pieces valid moves. Check if king is in those valid moves
    public boolean inCheck(Board board){

        ArrayList<Piece> pieces;
        ArrayList<Position> validMoves;

        if(this.isWhite())
            pieces = board.getBlackPieces();
        else
            pieces = board.getWhitePieces();

        for (Piece piece : pieces) {
            validMoves = piece.findValidMoves(board);
            for(Position pos : validMoves){
                if(pos.getX() == this.getPos().getX() && pos.getY() == this.getPos().getY()){
                    if(!piece.isObstructed(board,piece.getPos(),this.getPos())){
                        System.out.println("King in Check");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
