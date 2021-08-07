package com.company;
import com.company.Pieces.*;

/*

    Creates the board.

    2d array of tiles

    tf 05/08/2021
*/

public class Board
{

    private final Tile[][] boardArr = new Tile[64][64];

    /**
     * minus 1 for array
     */
    private int boardSize = 8 - 1;

    /**
     * constructor just initialises the board.
     */
    public Board(){
        initBoard();
    }

    /**
     * Creates the board. Manually placed pieces.
     * Places pieces and correct place and sets the position
     * [0][0] bottom left
     * [7][7] top right
     */
    public void initBoard()
    {
        //White Side
        boardArr[0][0] = new Tile(0,0,new Pawn(true,0,0));
        boardArr[1][0] = new Tile(1,0,new Pawn(true,1,0));
        boardArr[2][0] = new Tile(2,0,new Pawn(true,2,0));
        boardArr[3][0] = new Tile(3,0,new Pawn(true,3,0));
        boardArr[4][0] = new Tile(4,0,new Pawn(true,4,0));
        boardArr[5][0] = new Tile(5,0,new Pawn(true,5,0));
        boardArr[6][0] = new Tile(6,0,new Pawn(true,6,0));
        boardArr[7][0] = new Tile(7,0,new Pawn(true,7,0));

        boardArr[0][1] = new Tile(0,1,new Rook  (true,0,1));
        boardArr[1][1] = new Tile(1,1,new Knight(true,1,1));
        boardArr[2][1] = new Tile(2,1,new Bishop(true,2,1));
        boardArr[3][1] = new Tile(3,1,new Queen (true,3,1));
        boardArr[4][1] = new Tile(4,1,new King  (true,4,1));
        boardArr[5][1] = new Tile(5,1,new Bishop(true,5,1));
        boardArr[6][1] = new Tile(6,1,new Knight(true,6,1));
        boardArr[7][1] = new Tile(7,1,new Rook  (true,7,1));

        //Black Side
        boardArr[0][6] = new Tile(0,6, new Pawn(false,0,6));
        boardArr[1][6] = new Tile(1,6, new Pawn(false,1,6));
        boardArr[2][6] = new Tile(2,6, new Pawn(false,2,6));
        boardArr[3][6] = new Tile(3,6, new Pawn(false,3,6));
        boardArr[4][6] = new Tile(4,6, new Pawn(false,4,6));
        boardArr[5][6] = new Tile(5,6, new Pawn(false,5,6));
        boardArr[6][6] = new Tile(6,6, new Pawn(false,6,6));
        boardArr[7][6] = new Tile(7,6, new Pawn(false,7,6));

        boardArr[0][7] = new Tile(0,7, new Rook  (false,0,7));
        boardArr[1][7] = new Tile(1,7, new Knight(false,1,7));
        boardArr[2][7] = new Tile(2,7, new Bishop(false,2,7));
        boardArr[3][7] = new Tile(3,7, new Queen (false,3,7));
        boardArr[4][7] = new Tile(4,7, new King  (false,4,7));
        boardArr[5][7] = new Tile(5,7, new Bishop(false,5,7));
        boardArr[6][7] = new Tile(6,7, new Knight(false,6,7));
        boardArr[7][7] = new Tile(7,7, new Rook  (false,7,7));
    }

    public int getBoardSize(){return boardSize;}

    /**
     * Test method Delete l8 i guess
     * @return returns the board array
     */
    public Tile[][] returnArr()
    {
        return boardArr;
    }
}