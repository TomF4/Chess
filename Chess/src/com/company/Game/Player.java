package com.company.Game;

/*
    colour and whether is a computer or not

    tf 05/08/2021
 */

import com.company.Board.Board;
import com.company.Pieces.Piece;
import com.company.Position;

public class Player
{

    private boolean isWhite;
    private Piece[] pieces;
    private int score;

    public Player(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite(){
        return isWhite;
    }
}