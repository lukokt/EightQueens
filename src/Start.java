import gui.ChessCanvas;
import classes.ChessBoard;
import classes.ChessLogic;

import javax.swing.*;

public class Start {

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Eight Queens Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ChessBoard chessBoard 	= new ChessBoard();

        ChessLogic chessLogic	= new ChessLogic(chessBoard);

        ChessCanvas chessCanvas	= new ChessCanvas(chessBoard);

        frame.getContentPane().add(chessCanvas);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

        chessLogic.solve(chessCanvas);
    }


}
