package com.company.Pieces;

import com.company.Board;
import com.company.Position;
import com.company.Tile;

/*
   abstract class for all pieces

   Thomas Franks
   05/08/2021
 */
public abstract class Piece
{


    private boolean  m_isWhite = false;
    private boolean  m_isEliminated = false;
    private Position m_pos = new Position();

    /**
     * @param isWhite is white or not
     */
    public Piece(boolean isWhite)
    {
        m_isWhite = isWhite;
    }
    public Piece(boolean isWhite,int x,int y)
    {
        m_isWhite = isWhite;
        m_pos.setX(x);
        m_pos.setY(y);
    }

    // get/set
    public boolean isWhite()     { return this.m_isWhite; }
    public boolean isEliminated(){ return this.m_isEliminated; }
    public Position getPos()     { return this.m_pos; }

    public void setWhite() { this.m_isWhite = true; }
    public void eliminate(){ this.m_isEliminated = true; }
    public void setPos(int x,int y) { this.m_pos.setX(x);this.m_pos.setY(y); }

    /**
     * Checks to see whether a move is valid.
     * @param board takes in current board
     * @param start begining tile
     * @param end   finishing tile
     * @return true if valid move
     */
    public abstract boolean validMove(Board board, Tile start, Tile end);



    @Override
    public String toString() {
        return "{" +
                "White=" + m_isWhite + "," +
                "Eliminated=" + m_isEliminated + "," +
                "pos=" + m_pos + "," + '}';
    }
}