package com.company.Pieces;

import com.company.Board.Board;
import com.company.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{


    /**
     * @param isWhite is white or not
     */
    public Queen(boolean isWhite) {
        super(isWhite);
        setPieceType(PieceType.QUEEN);
    }
    public Queen(boolean isWhite,int x,int y){
        super(isWhite, x, y);
        setPieceType(PieceType.QUEEN);
    }


    /**
     * Method relies on bishop and rook (findvalidmoves) to function as ive reused the code
     * @param board current board
     * @return list of queen moves
     */
    @Override
    public ArrayList<Position> findValidMoves(Board board) {
        ArrayList<Position> rookMoves;
        ArrayList<Position> bishopMoves;
        final ArrayList<Position> queenMoves = new ArrayList<>();

        //create rook and bishop for reuse
        Rook   rook   = new Rook(this.isWhite());
        Bishop bishop = new Bishop(this.isWhite());
        //set to this queens position
        rook.setPos(this.getPos().getX(), this.getPos().getY());
        bishop.setPos(this.getPos().getX(), this.getPos().getY());
        //reuse moves from rook and bishop
        rookMoves =  rook.findValidMoves(board);
        bishopMoves =  bishop.findValidMoves(board);
        //add mvoes to queen moves
        queenMoves.addAll(rookMoves);
        queenMoves.addAll(bishopMoves);
        return queenMoves;
    }

    /**
     * reuses the rook and bishop code as queen is jujst both
     * @param board current board
     * @param origin origin pos
     * @param destination destination pos
     * @return true if blocked
     */
    @Override
    public boolean isObstructed(Board board, Position origin, Position destination) {
        Rook rook = new Rook(this.isWhite());
        Bishop bishop = new Bishop(this.isWhite());

        boolean movingDiagonal   = false;
        boolean movingHorizontal = false;

        Position differencePosition = destination.subtract(origin);
        int dX = differencePosition.getX();
        int dY = differencePosition.getY();

        //rook only moves in either x or y not both
        if(dX != 0 && dY != 0)
            movingDiagonal = true;
        else
            movingHorizontal = true;

        bishop.setPos(this.getPos().getX(), this.getPos().getY());
        rook.setPos(this.getPos().getX(), this.getPos().getY());
        if(movingDiagonal)
            return bishop.isObstructed(board,origin,destination);
        else if(movingHorizontal)
            return rook.isObstructed(board,origin,destination);
        return false;
    }
}