package classes;

import gui.ChessCanvas;

public class ChessLogic extends Thread {

	private ChessBoard	chessBoard	= null;
	
	private ChessCanvas	chessCanvas	= null;
	
	public ChessLogic(ChessBoard chessBoard) {
		this.setChessBoard(chessBoard);
	}
	
	private boolean solution	= false;
	
	
	public boolean solve(ChessCanvas chessCanvas) {
		
		this.chessCanvas = chessCanvas;
		
		this.start();
		
		return true;
	}
	
	public void run() {
		this.putQueen(0);
	}
	
	private boolean putQueen( int row ) {
		
		for(int column = 0; column < this.getChessBoard().getHeight(); column++) {
			
			if( this.getChessBoard().getField(row, column).isFree() ) {
				
				this.getChessBoard().getField(row, column).setFigure(new ChessFigure());
				this.updateBoard( row, column, false );

				
				try {
					this.chessCanvas.draw();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				

				if( row < this.getChessBoard().getWidth() - 1 ) {
					this.putQueen(row+1);
					
				}
				else {
					this.solution = true;
				}
				
				if( this.solution ) { return true;}

				this.getChessBoard().getField(row, column).setFigure(null);
				this.updateBoard( row, column, true );
				
			}
		}
		
		return false;
	}
	/*
	public void putQueen(int row, int column) {
		
		this.getChessBoard().getField(row, column).setFigure(new ChessFigure());
		
		this.updateBoard( row, column, false );
		
	}
	*/
	
	// TODO change into four loops !!
	private void updateBoard(int row, int column, boolean isFree) {
		
		int width	= this.getChessBoard().getWidth();
		int height	= this.getChessBoard().getHeight();
		
		int x = row;
		while( --x >= 0 ) this.getChessBoard().getField(x, column).setFree(isFree);
		
		x = row;
		while( ++x < width ) this.getChessBoard().getField(x, column).setFree(isFree);
		
		int y = column;
		while( --y >= 0 ) this.getChessBoard().getField(row, y).setFree(isFree);
		
		y = column;
		while( ++y < height ) this.getChessBoard().getField(row, y).setFree(isFree);
		
		x = row;
		y = column;
		while( --x >= 0 && --y >= 0) this.getChessBoard().getField(x, y).setFree(isFree);

		
		x = row;
		y = column;
		while( ++x < width && ++y < height ) this.getChessBoard().getField(x, y).setFree(isFree);
		
		x = row;
		y = column;
		while( ++x < width && --y >= 0 ) this.getChessBoard().getField(x, y).setFree(isFree);
		
		x = row;
		y = column;
		while( --x >= 0 && ++y < height ) this.getChessBoard().getField(x, y).setFree(isFree);
	}
	

	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

}
