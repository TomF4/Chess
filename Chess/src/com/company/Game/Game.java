package com.company.Game;

import com.company.Board.Board;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game will run from this class
 * ekko yi ali shen kayn
 * 08/08/2021
 */

//enum of game state


public class Game
{
    private static GameStatus gameStatus = GameStatus.PLAYING;

    public static void main(String[] args)
    {

        Board board = new Board();

        Player player1 = new Player(true);
        Player player2 = new Player(false);

        //record of moves
        ArrayList<String> whiteMoves = new ArrayList<>();
        ArrayList<String> blackMoves = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        String turn = "white";

        //game loop
        while(true)
        {
            if (turn.equals("white")){
                System.out.println("White enter a move");
                String whiteMove = scanner.nextLine();
                System.out.println(whiteMove);
                //do stuff
                //do stuff
                turn = "black";
            }
            else {
                System.out.println("Black enter a move");
                String blackMove = scanner.nextLine();
                System.out.println(blackMove);
                //do stuff
                //do stuff
                turn = "white";
            }
            System.out.println();
        }
    }
}