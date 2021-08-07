package com.company;

/*
    colour and whether is a computer or not

    tf 05/08/2021
 */

import com.company.Pieces.Piece;

public class Player {

    public boolean isWhite;
    public boolean isHuman;

    public Player(boolean isWhite,boolean isHuman)
    {
        this.isWhite = isWhite;
        this.isHuman = isHuman;
    }

    public void move(Piece piece,Position start, Position end)
    {

    }

}
