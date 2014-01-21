package gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import config.GuiConfig;

import classes.ChessBoard;
import classes.ChessField;

public class ChessCanvas extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	private ChessBoard	chessBoard	= null;
	
	public ChessCanvas(ChessBoard chessBoard) {
		this.setChessBoard(chessBoard);
		this.setSize();
	}
	
	private void setSize() {
        this.setPreferredSize( new Dimension(
        		chessBoard.getWidth()*GuiConfig.FIELD_WIDTH		+ 2*GuiConfig.BORDER_WIDTH,
        		chessBoard.getHeight()*GuiConfig.FIELD_HEIGHT	+ 2*GuiConfig.BORDER_WIDTH 
        		)
        );
	}
	
	public void update(Graphics g) {
		this.paint(g);
	}
	
	public void paint(Graphics g) {

		// paint borders - horizontal
		for( int i = 0; i < GuiConfig.BORDER_HORIZONTAL_LETTERS.length; i++ ) {
		
			String s = GuiConfig.BORDER_HORIZONTAL_LETTERS[i];
			
			int width = this.getFontMetrics(g.getFont()).stringWidth(s);
			
			int x = GuiConfig.BORDER_WIDTH + i * GuiConfig.FIELD_WIDTH + GuiConfig.FIELD_WIDTH/2 - width /2 ;
			
			g.drawString(s, x, GuiConfig.BORDER_WIDTH / 2);
			g.drawString(s, x, GuiConfig.BOARD_HEIGHT + GuiConfig.BORDER_WIDTH*3/2);
		}

		// paint borders - vertical
		for( int i = 0; i < GuiConfig.BORDER_VERTICAL_LETTERS.length; i++ ) {
		
			String s = GuiConfig.BORDER_VERTICAL_LETTERS[i];
			
			int width = this.getFontMetrics(g.getFont()).stringWidth(s);
			
			int y = GuiConfig.BORDER_WIDTH + i * GuiConfig.FIELD_HEIGHT + GuiConfig.FIELD_HEIGHT/2 + width/2;
			
			g.drawString(s, GuiConfig.BORDER_WIDTH / 2 - width /2, y);
			g.drawString(s, GuiConfig.BOARD_WIDTH + GuiConfig.BORDER_WIDTH*3/2 - width /2, y);
		}
		
		
		// paint fields
		for( int x = 0; x < this.getChessBoard().getWidth(); x++ ) {
			for( int y = 0; y < this.getChessBoard().getHeight(); y++ ) {

				((ChessField)this.getChessBoard().getField(x, y)).paint(g);
			}
		}
	}
	

	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	public void draw() {
		Graphics g = this.getGraphics();
		this.update(g);
		
	}
}
