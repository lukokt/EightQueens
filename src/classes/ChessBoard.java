package classes;

import config.ChessConfig;

public class ChessBoard extends Board2D {

	public ChessBoard() {
		super(ChessConfig.BOARD_WIDTH, ChessConfig.BOARD_HEIGHT, ChessField.class);
	}
	
	 public ChessField getField(int x, int y) {
		return (ChessField)(super.getBoard(x, y)); //board[x][y]);
	}
	 
	 
	public void print() {
		for( int y = 0; y < this.getHeight(); y++ ) {
			System.out.println("");
			for( int x = 0; x < this.getWidth(); x++ ) {
				
				char c = '0';
				if( !this.getField(x, y).isEmpty() ) {
					c = '1';
				}
				System.out.print(c);
			}
		}
	}
	
}
