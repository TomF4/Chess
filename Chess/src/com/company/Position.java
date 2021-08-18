package com.company;

/*
    Position class to represent a position

    Mainly just makes methods cleaner in other classes eg tile and piece.
    idk its just cool like a vector or something


 */

import java.util.Comparator;

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
     * Add a position to another
     * @param posA position to be added to this
     * @return return a new position
     */
    public Position add(Position posA) { return new Position(this.getX()+posA.getX(),this.getY()+posA.getY()); }
    /**
     * create a new position from adding ints to x,y
     * @param x x to be added
     * @param y y to be added
     * @return new position
     */
    public Position add(int x,int y) { return new Position(this.getX()+x,this.getY()+y); }

    /**
     * This method will mainly be used to find obstructions by returning a vector between the DESTINATION and the origin
     * @param posA original position
     * @return vector
     */
    public Position subtract(Position posA) { return new Position(this.getX()- posA.getX(),this.getY()-posA.getY()); }

    public Position subtract(int x,int y)   { return new Position(this.getX()-x,this.getY()-y); }

    @Override
    public String toString() {
        return "Position[x:"+m_x+","+"y:"+m_y+"]";
    }
}