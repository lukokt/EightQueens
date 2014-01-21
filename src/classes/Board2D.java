package classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Board2D {

	private int width			= 0;
	private int height			= 0;
	
	private Object[][] board	= null;
	
	public Board2D( int width, int height, Class fieldClass) {
		this.setWidth(width);
		this.setHeight(height);
		this.initBoard(fieldClass);
	}

	private void initBoard(Class fieldClass) {
		this.board = new BoardField[this.getWidth()][this.getHeight()];
		for( int x = 0; x < this.getWidth(); x++ ) {
			for( int y = 0; y < this.getHeight(); y++ ) {
				
				Object obj	= null;
				Class[]	argsClass	= {Integer.class, Integer.class};
				
				try {
					Object[] args	= {new Integer(x), new Integer(y)};
					Constructor constructor = fieldClass.getConstructor ( argsClass );
					obj = constructor.newInstance ( args );
				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}

				this.board[x][y] = obj;
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Object getBoard(int x, int y) {
		return (this.board[x][y]);
	}

}
