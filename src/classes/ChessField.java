package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import config.GuiConfig;

public class ChessField extends BoardField {

	private Color	color	= null;

	private ChessFigure	figure	= null;
	
	private int		takenCounter	= 0;
	
	public ChessField() {
		super(0, 0);
	}
	
	public ChessField(Integer x, Integer y) {
		super(x.intValue(), y.intValue());
		this.setColorByPosition(x.intValue(), y.intValue());
	}
	
	private void setColorByPosition(int x, int y) {
		if( x % 2 == 0 ) {
			if( y % 2 == 0) { 
				this.setColor(GuiConfig.FIELD_COLOR_WHITE);
			}
			else {
				this.setColor(GuiConfig.FIELD_COLOR_BLACK);
			}
		}
		else {
			if( y % 2 == 0) {
				this.setColor(GuiConfig.FIELD_COLOR_BLACK);
			}
			else {
				this.setColor(GuiConfig.FIELD_COLOR_WHITE);
			}
		}
	}

	public void paint(Graphics g) {
		
		int startX	= this.getPositionX()*GuiConfig.FIELD_WIDTH 	+ GuiConfig.BORDER_WIDTH;
		int startY	= this.getPositionY()*GuiConfig.FIELD_HEIGHT	+ GuiConfig.BORDER_WIDTH;
		
		// draw field
		g.setColor(this.getColor());
		g.fillRect(startX, startY, GuiConfig.FIELD_WIDTH, GuiConfig.FIELD_HEIGHT);
		
		// draw border
		g.setColor(GuiConfig.FIELD_BORDER_COLOR);
		g.drawRect(startX, startY, GuiConfig.FIELD_WIDTH, GuiConfig.FIELD_HEIGHT);
	
		// draw figure
		if( !this.isEmpty() ) {
			g.setColor(Color.RED);
	//		g.fillRoundRect(startX + 20, startY + 20, 40, 40, 40, 40);
			Image img = this.getFigure().getImage();
			int xBorder = (GuiConfig.FIELD_WIDTH - img.getWidth(null) ) / 2;
			int yBorder = (GuiConfig.FIELD_HEIGHT - img.getHeight(null) ) / 2;
			g.drawImage(img, startX + xBorder, startY + yBorder, img.getWidth(null), img.getHeight(null), null);
		}
		
		// draw taken position
		if( !this.isFree() ) {
	//		g.setColor(Color.GREEN);
	//		g.fillRoundRect(startX + 30, startY + 30, 20, 20, 40, 40);
		}
	}
	
	public Color getColor() {
		return color;
	}

	public ChessFigure getFigure() {
		return figure;
	}

	public void setFigure(ChessFigure figure) {
		this.figure = figure;
		this.setFree( (figure == null) );
	}
	
	public boolean isEmpty() {
		return (this.figure == null);
	}
	

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isFree() {
		return (takenCounter == 0);
	}

	public void setFree(boolean free) {
		if( free )
			takenCounter--;
		else 
			takenCounter++;
	}

}
