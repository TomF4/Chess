package com.company;

/*
    colour and whether is a computer or not

    tf 05/08/2021
 */

import com.company.Pieces.Piece;

public class Player {

    public boolean isComputer;
    public boolean isHuman;

    public Player(boolean isComputer,boolean isHuman)
    {
        this.isComputer = isComputer;
        this.isHuman    = isHuman;
    }

    public void move(Piece piece,Position start, Position end)
    {

    }

}
