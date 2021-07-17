package controller;

import view.Menu;
import model.Screen;
import javax.swing.JFrame;

public class Main {

    // <editor-fold defaultstate="collapsed" desc="--- VARIABLES ---">
    public static JFrame frame;
    // </editor-fold>

    public static void main(String[] args) {

        frame = new JFrame("Jelly Jumper");
        frame.setSize(1000, 1000);
        frame.setLocation(Screen.getWidth() / 2 - frame.getBounds().width / 2, 0); // Opening the frame in the middle of the screen (at the very top)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new Menu());
        frame.setVisible(true);
        
    }
}
