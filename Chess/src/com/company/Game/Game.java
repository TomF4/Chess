package com.company.Game;

import com.company.Board.Board;
import com.company.Pieces.Piece;
import com.company.Pieces.PieceType;
import com.company.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Game class contains board start up and general rules
 * This class does not yet contain ways of:
 *      -Checking for check/checkmate
 *      -Checking for obstruction on piece moves
 *      -Castling and en passant
 * 08/08/2021
 */


/*
    TODO check and check mate
    TODO cant mvoe if result in check
    TODO castling
    TODO pawn takes


 */
public class Game
{
    private static GameStatus gameStatus = GameStatus.PLAYING;
    private Board board;
    private Player[] players;
    private ArrayList<Move> movesPlayed;
    private Player currentTurn;

    /**
     * initialises the board and player turn (resets the game)
     */
    private void initialise(Player player1,Player player2)
    {
        board.initBoard();
        players[0] = player1;
        players[1] = player2;

        if(player1.isWhite())
            this.currentTurn = player1;
        else
            this.currentTurn = player2;
        movesPlayed.clear();
        setGameStatus(GameStatus.PLAYING);
    }
    /**
     * this method will move the piece
     * @param currentPlayer current player
     * @param start starting tile pos
     * @param end ending tile pos
     * @return true when move complete
     */
    private boolean makeMove(Player currentPlayer, Position start, Position end)
    {
        //create the move
        Move move = new Move(currentPlayer, board.getTile(start),board.getTile(end));

        //get the piece to be moved from board array
        Piece movingPiece = board.getTile(start).getPiece();

        if(!checkIfLegalMove(move))
            return false;

        //TODO castling and en passant go here i guess



        return true;
    }

    /**
     * checks to see if the moves is within board, not same colour and whether piece is obstructed.
     * Method is most likely only used in "makeMove"
     * @param move takes in the move to be played
     * @return true if move can happen
     */
    private boolean checkIfLegalMove(Move move)
    {
        //get valid moves
        List<Position> validMoves = move.getPiecedMoved().findValidMoves(board);

        Position originPos = move.getStart().getTilePos();
        Position endPos = move.getEnd().getTilePos();
        Piece piece = move.getPiecedMoved();

        for (Position movePos: validMoves)
        {
            //if the end position is in the list of moves
            if(endPos == movePos){
                //if within board and is not same colour
                if (Board.isWithinBoard(endPos) && piece.isWhite() != board.getTile(endPos).getPiece().isWhite())
                    if(piece.isObstructed(board, originPos, endPos))
                        return true;
                else //piece is same colour
                    return false;
            }
        }
        return false;
    }

    public static GameStatus getGameStatus()           { return gameStatus;   }
    public static void setGameStatus(GameStatus status){ gameStatus = status; }

}
/*
     Board board = new Board();
        Move move;
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


                Iterator<Position> iterator = validMoves.iterator();

        //remove all same colour piece moves
        /*Doesnt seem to be needed and is wasteful and overcomplicated
        * if (piece.isWhite() != board.getTile(end).getPiece().isWhite()) workds*/
//while(iterator.hasNext()) {
//    Position pos = iterator.next();
//    if(board.getTile(pos).getPiece() != null)
//        if(board.getTile(pos).getPiece().isSameColour(move.getPiecedMoved())){
//            iterator.remove();
//        }
//}

