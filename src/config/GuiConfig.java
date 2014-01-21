package config;

import java.awt.Color;

public class GuiConfig {

	// fields dimension
	public static int 		FIELD_WIDTH					= 80;
	public static int 		FIELD_HEIGHT				= 80;
	
	// boreders
	public static int		BORDER_WIDTH				= 40;
	
	public static String[]	BORDER_HORIZONTAL_LETTERS	= {"a", "b", "c", "d", "e", "f", "g", "h"};
	public static String[] 	BORDER_VERTICAL_LETTERS		= {"8", "7", "6", "5", "4", "3", "2", "1"};
	
	// board dimension
	public static int 		BOARD_ROWS					= 8;
	public static int 		BOARD_COLUMNS				= 8;
	public static int		BOARD_WIDTH					= GuiConfig.FIELD_WIDTH  * GuiConfig.BOARD_ROWS;
	public static int		BOARD_HEIGHT				= GuiConfig.FIELD_HEIGHT * GuiConfig.BOARD_COLUMNS;
	
	// fields colors
	public static Color 	FIELD_COLOR_BLACK			= Color.GRAY;
	public static Color 	FIELD_COLOR_WHITE			= Color.WHITE;

	public static Color 	FIELD_BORDER_COLOR			= Color.BLACK;
}
