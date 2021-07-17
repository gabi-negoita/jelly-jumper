/*
    TEMPLATE METHOD PATTERN USED
 */
package view;

import controller.Button;
import controller.ButtonController;
import controller.GoToMenu;
import controller.IElectronicButton;
import model.Player;
import model.MenuButton;
import model.ResetLevelButton;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public abstract class ALevel extends JPanel {

    // <editor-fold defaultstate="collapsed" desc="--- VARIABLES ---">
    // Commands
    protected IElectronicButton controlButton;
    protected GoToMenu goToMenu;
    protected Button goToMenuCommand;

    protected Player player;
    protected Point playerInitialPosition;
    protected int[][] blocks = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    // </editor-fold>

    protected ALevel() {
        super();

//        this.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent evt) {
//                levelKeyPressed(evt);
//            }
//        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                levelMousePressed(evt);
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                levelMouseReleased(evt);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="--- METHODS ---">
    protected void createPlayer(Point p) {
        player = Player.getInstance();
        player.setPosition(p);
    }

//    protected void levelKeyPressed(KeyEvent e) {
//        System.out.println("Level key pressed ...");
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            jumpLeft();
//        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            jumpRight();
//        }
//    }
    protected void levelMousePressed(MouseEvent e) {
        System.out.println("Mouse pressed ...");

        MenuButton menuButton = MenuButton.getInstance();
        ResetLevelButton resetButton = ResetLevelButton.getInstance();

        // Checking if the reset button has been pressed
        if (e.getX() > resetButton.getX()
                && e.getX() < (resetButton.getX() + resetButton.getSize())
                && e.getY() > resetButton.getY()
                && e.getY() < (resetButton.getY() + resetButton.getSize())) {
            resetLevel();
        } // Checking if the menu button has been pressed 
        else if (e.getX() > menuButton.getX()
                && e.getX() < (menuButton.getX() + menuButton.getSize())
                && e.getY() > menuButton.getY()
                && e.getY() < (menuButton.getY() + menuButton.getSize())) {
            controlButton = ButtonController.getButton();
            goToMenu = new GoToMenu(controlButton);
            goToMenuCommand = new Button(goToMenu);
            goToMenuCommand.buttonPressed(this);
        } else if (e.getX() < 500) {
            jumpLeft();
        } else {
            jumpRight();
        }
    }

    protected int getBlocksNumber() {
        int blocksNumber = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                if (blocks[j][i] != 0) {
                    blocksNumber++;
                }
            }
        }
        return blocksNumber;
    }

    protected void levelMouseReleased(MouseEvent e) {
        System.out.println("Mouse released ...");

        int blocksNumber = getBlocksNumber();

        if (blocksNumber == 1) {
            System.out.println("WINNER!");
            levelAccomplished();
        }
    }

    protected void jumpLeft() {
        System.out.println("Jumping left ... ");

        changeBlock();

        // Changing the player's position
        player.setPosition(new Point(player.getPosition().x - 100, player.getPosition().y));

        goDown();

        repaint();

    }

    protected void jumpRight() {
        System.out.println("Jumping right ... ");

        changeBlock();

        // Changing the player's position
        player.setPosition(new Point(player.getPosition().x + 100, player.getPosition().y));

        goDown();

        repaint();

    }

    protected void goDown() {
        int playerX = player.getPosition().x / 100;
        int playerY = player.getPosition().y / 100;

        try {
            if (blocks[playerY + 1][playerX] == 0) {
                player.setPosition(new Point(player.getPosition().x, (playerY + 1) * 100));
                goDown();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("GAME OVER!");
            gameOver();
        }

    }

    protected void changeBlock() {
        int playerX = player.getPosition().x / 100;
        int playerY = player.getPosition().y / 100;

        try {
            switch (blocks[playerY + 1][playerX]) {
                case 1: {
                    blocks[playerY + 1][playerX] = 0;
                    break;
                }
                case 2: {
                    blocks[playerY + 1][playerX] = 1;
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("GAME OVER!");
            gameOver();

        }
    }

    protected Point getPlayerCurrentPosition() {
        return player.getPosition();
    }

    protected abstract void createMap();

    protected abstract void resetLevel();

    protected abstract void levelAccomplished();

    protected abstract void gameOver();

    // </editor-fold>
}
