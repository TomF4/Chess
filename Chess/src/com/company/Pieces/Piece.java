package com.company.Pieces;

import com.company.Board.Board;
import com.company.Position;

import java.util.List;

/*
   abstract class for all pieces

    piece class does not handle validity of moves. Only where it can move. it does only return moves on board space.
    eg no check handling etc.

   Thomas Franks
   05/08/2021
 */
public abstract class Piece
{
    private boolean  isWhite = false;
    private boolean  isEliminated = false;
    private Position pos = new Position();
    private PieceType pieceType;

    /**
     * @param isWhite is white or not
     */
    public Piece(boolean isWhite)
    {
        this.isWhite = isWhite;
    }
    public Piece(boolean isWhite,int x,int y)
    {
        this.isWhite = isWhite;
        pos.setX(x);
        pos.setY(y);
    }

    // get/set
    public boolean  isWhite()       { return this.isWhite; }
    public boolean  isEliminated()  { return this.isEliminated; }
    public Position getPos()        { return this.pos; }
    public PieceType getPieceType() { return this.pieceType; }


    public void setWhite()          { this.isWhite = true; }
    public void eliminate()         { this.isEliminated = true; }
    public void setPos(int x,int y) { this.pos.setX(x);this.pos.setY(y); }
    public void setPieceType(PieceType pieceType) { this.pieceType = pieceType; }


    /**
     * Finds all legal moves a
     * @param board current board
     * @return A list of positions that are WITHIN the size of the board
     */
    public abstract List<Position> findValidMoves(Board board);

    public void printValidMoves(Board board){
        System.out.println("Possible Moves"+this.findValidMoves(board).toString());
    }


    //TODO moves this kind of method to the game/board class (testing atm) as well as a colour check thing
    public boolean isWithinBoard(Position position) {
        return position.getY() >= 0 && position.getX() >= 0 && position.getX() < 8 && position.getY() < 8; //within board
    }

    public boolean isSameColour(Piece piece){
        if(this.isWhite && piece.isWhite)
            return true;
        else if(!this.isWhite && !piece.isWhite)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return pieceType+ "{" +
                "White=" + isWhite + "," +
                "Eliminated=" + isEliminated + "," +
                pos + "," + "Type="+pieceType +'}';
    }
}