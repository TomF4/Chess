package com.company.Game;

import com.company.Board.Board;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game will run from this class
 * 08/08/2021
 */

//enum of game state


public class Game
{
    private static GameStatus gameStatus = GameStatus.PLAYING;

    public static void main(String[] args)
    {

        Board board = new Board();

        Player whitePlayer = new Player(true);
        Player blackPlayer = new Player(false);

        //record of moves
        ArrayList<String> whiteMoves = new ArrayList<>();
        ArrayList<String> blackMoves = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.println("===================================================");
        System.out.println("======================Chess========================");

        //game loop
        while(true)
        {
            Player currentPlayer = whitePlayer;

            //Whites Move
            System.out.println("White enter a move");
            String whiteMove = scanner.nextLine();
            System.out.println(whiteMove);
            //do stuff
            //do stuff

            //Blacks Move
            System.out.println("Black enter a move");
            String blackMove = scanner.nextLine();
            System.out.println(blackMove);
            //do stuff
            //do stuff

            System.out.println();
        }
    }

    public static GameStatus getGameStatus()           { return gameStatus;   }
    public static void setGameStatus(GameStatus status){ gameStatus = status; }

}