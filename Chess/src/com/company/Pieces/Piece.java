package com.company.Pieces;

import com.company.Board;
import com.company.Position;

import java.util.List;

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
    public boolean  isWhite()       { return this.m_isWhite; }
    public boolean  isEliminated()  { return this.m_isEliminated; }
    public Position getPos()        { return this.m_pos; }

    public void setWhite()          { this.m_isWhite = true; }
    public void eliminate()         { this.m_isEliminated = true; }
    public void setPos(int x,int y) { this.m_pos.setX(x);this.m_pos.setY(y); }


    /**
     * Finds all legal moves a
     * @param board current board
     * @return A list of positions that are WITHIN the size of the board.
     */
    public abstract List<Position> findValidMoves(Board board);


    @Override
    public String toString() {
        return "{" +
                "White=" + m_isWhite + "," +
                "Eliminated=" + m_isEliminated + "," +
                 m_pos + "," + '}';
    }
}