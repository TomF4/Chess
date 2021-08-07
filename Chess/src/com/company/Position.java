package com.company;

/*
    Position class to represent a position

    Mainly just makes methods cleaner in other classes eg tile and piece.
    idk its just cool like a vector or something


 */

public class Position
{
    int m_x;
    int m_y;

    public Position(){
        m_y = 0;
        m_x = 0;
    }
    public Position(int x, int y) {
        m_x = x;
        m_y = y;
    }
    public int getX() { return m_x; }
    public int getY() { return m_y; }

    public void setX  (int x){ m_x = x; }
    public void setY  (int y){ m_y = y; }

    /**
     * static add two vectors
     */
    public static Position add(Position posA,Position posB) { return new Position(posA.getX()+posB.getX(),posA.getY()+posB.getY()); }


    @Override
    public String toString() {
        return "Position[x:"+m_x+","+"y:"+m_y+"]";
    }
}