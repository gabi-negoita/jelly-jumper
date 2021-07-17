package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import model.BackgroundMenu;
import model.ExitButton;
import model.HelpButton;
import controller.ILevelBackground;
import controller.GoToLevel1;
import controller.IElectronicButton;
import controller.GoToLevel2;
import controller.ButtonController;
import controller.Button;

public class Menu extends JPanel {

    // <editor-fold defaultstate="collapsed" desc="--- VARIABLES ---">
    protected ILevelBackground background;

    protected IElectronicButton controlButton;

    protected GoToLevel1 goToLevel1;
    protected Button goToLevel1Command;

    protected GoToLevel2 goToLevel2;
    protected Button goToLevel2Command;

    protected HelpButton helpButton;
    protected ExitButton exitButton;

    protected boolean help;
    protected boolean exit;
    // </editor-fold>

    public Menu() {
        super();

        background = new BackgroundMenu();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                levelMousePressed(evt);
            }
        });

        helpButton = HelpButton.getInstance();
        exitButton = ExitButton.getInstance();
    }

    protected void help() {
        help = true;
        repaint();
    }

    protected void exit() {
        exit = true;
        repaint();
    }

    protected void level1() {
        controlButton = ButtonController.getButton();
        goToLevel1 = new GoToLevel1(controlButton);
        goToLevel1Command = new Button(goToLevel1);
        goToLevel1Command.buttonPressed(this);
    }

    protected void level2() {
        controlButton = ButtonController.getButton();
        goToLevel2 = new GoToLevel2(controlButton);
        goToLevel2Command = new Button(goToLevel2);
        goToLevel2Command.buttonPressed(this);
    }

    // <editor-fold defaultstate="collapsed" desc="--- METHODS ---">
    protected void levelMousePressed(MouseEvent e) {
        if (help) {
            help = false;
            repaint();
        } else {
            if (e.getX() > helpButton.getX()
                    && e.getX() < helpButton.getX() + helpButton.getSize()
                    && e.getY() > helpButton.getY()
                    && e.getY() < helpButton.getY() + helpButton.getSize()) {
                // Help button pressed
                help();

            } else if (e.getX() > exitButton.getX()
                    && e.getX() < exitButton.getX() + exitButton.getSize()
                    && e.getY() > exitButton.getY()
                    && e.getY() < exitButton.getY() + exitButton.getSize()) {
                // Exit button pressed
                exit();

            } else if (e.getX() > this.getBounds().width / 2 - 200
                    && e.getX() < this.getBounds().width / 2 - 100
                    && e.getY() > this.getBounds().height / 2 - 100
                    && e.getY() < this.getBounds().height / 2) {
                // Render level 1
                level1();
            } else if (e.getX() > this.getBounds().width / 2 - 50
                    && e.getX() < this.getBounds().width / 2 + 50
                    && e.getY() > this.getBounds().height / 2 - 100
                    && e.getY() < this.getBounds().height / 2) {
                // Render level 2
                level2();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Rendering the background
        g.drawImage(background.getBackgroundImage(), 0, 0, this);

        if (help) {
            // Rendering the help text
            g.setColor(new Color(255 / 2, 255 / 2, 255 / 2, 100));
            g.fillRect(0, 0, this.getBounds().width, this.getBounds().height);

            g.setColor(new Color(0, 0, 0, 125));
            g.fillRoundRect(this.getBounds().width / 2 - 300, this.getBounds().height / 2 - 200, 600, 350, 90, 90);

            g.translate(0, -20);
            g.setColor(Color.DARK_GRAY);
            g.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 48));
            g.drawString("Win the game by finding", this.getBounds().width / 2 - 250, this.getBounds().height / 2 - 100);
            g.drawString("the route in such a way", this.getBounds().width / 2 - 250, this.getBounds().height / 2 - 50);
            g.drawString("that you will stand on", this.getBounds().width / 2 - 250, this.getBounds().height / 2);
            g.drawString("the last block remained", this.getBounds().width / 2 - 250, this.getBounds().height / 2 + 50);
            g.drawString("while others are destroyed.", this.getBounds().width / 2 - 250, this.getBounds().height / 2 + 100);

            g.translate(5, 5);
            g.setColor(Color.white);
            g.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 48));
            g.drawString("Win the game by finding", this.getBounds().width / 2 - 250, this.getBounds().height / 2 - 100);
            g.drawString("the route in such a way", this.getBounds().width / 2 - 250, this.getBounds().height / 2 - 50);
            g.drawString("that you will stand on", this.getBounds().width / 2 - 250, this.getBounds().height / 2);
            g.drawString("the last block remained", this.getBounds().width / 2 - 250, this.getBounds().height / 2 + 50);
            g.drawString("while others are destroyed.", this.getBounds().width / 2 - 250, this.getBounds().height / 2 + 100);

        } else if (exit) {
            // Exiting the game
            System.out.println("Exiting the game ...");
            System.exit(0);
        } else {
            // Rendering the help and exit buttons
            g.drawImage(helpButton.getButtonIcon(), helpButton.getX(), helpButton.getY(), this);
            g.drawImage(exitButton.getButtonIcon(), exitButton.getX(), exitButton.getY(), this);

            // Rendering the title
            int size = 100;

            g.setFont(new Font("Harlow Solid Italic", Font.BOLD, 72));

            g.setColor(Color.blue);
            g.drawString("Jelly Jumper", this.getBounds().width / 2 - 225, 100 - 2);

            g.setColor(Color.blue);
            g.drawString("Jelly Jumper", this.getBounds().width / 2 - 225, 100 + 2);

            g.setColor(Color.blue);
            g.drawString("Jelly Jumper", this.getBounds().width / 2 - 225 - 2, 100);

            g.setColor(Color.blue);
            g.drawString("Jelly Jumper", this.getBounds().width / 2 - 225 + 2, 100);

            g.setColor(Color.orange);
            g.drawString("Jelly Jumper", this.getBounds().width / 2 - 225, 100);

            // Rendering the level buttons       
            g.setFont(new Font("Bauhaus 93", Font.BOLD, 72));

            // 1
            g.setColor(Color.green);
            g.fillRoundRect(this.getBounds().width / 2 - 200, this.getBounds().height / 2 - 100, 100, 100, 25, 25);

            g.setColor(Color.white);
            g.drawRoundRect(this.getBounds().width / 2 - 200, this.getBounds().height / 2 - 100, 100, 100, 25, 25);
            g.drawString("1", this.getBounds().width / 2 - 170, this.getBounds().height / 2 - 25);

            // 2
            g.setColor(Color.green);
            g.fillRoundRect(this.getBounds().width / 2 - 50, this.getBounds().height / 2 - 100, 100, 100, 25, 25);

            g.setColor(Color.white);
            g.drawRoundRect(this.getBounds().width / 2 - 50, this.getBounds().height / 2 - 100, 100, 100, 25, 25);
            g.drawString("2", this.getBounds().width / 2 - 20, this.getBounds().height / 2 - 25);

            // 3
            g.setColor(Color.lightGray);
            g.fillRoundRect(this.getBounds().width / 2 + 100, this.getBounds().height / 2 - 100, 100, 100, 25, 25);

            g.setColor(Color.white);
            g.drawRoundRect(this.getBounds().width / 2 + 100, this.getBounds().height / 2 - 100, 100, 100, 25, 25);
            g.drawString("3", this.getBounds().width / 2 + 130, this.getBounds().height / 2 - 25);
        }
    }
    // </editor-fold>
}
