package com.company;

/**
 * Game will run from this class
 * ekko yi ali shen kayn
 * 08/08/2021
 */


public class Game
{

    //enum of game state
    public enum GameStatus
    {
        CHECK,
        CHECKMATE,
        DRAW,
        WIN,
        LOSS,
    }


    public static void main(String[] args)
    {

        Board board = new Board();

        Player player1 = new Player(true);
        Player player2 = new Player(true);

        //game loop
        while(true)
        {

            break;
        }
    }
}