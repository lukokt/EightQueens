package classes;

import java.awt.*;

public class ChessFigure {

	private Image image	= null;

	public ChessFigure() {
        this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gui/img/queen.png"));
	}

	public Image getImage() {
		return this.image;
	}

}
