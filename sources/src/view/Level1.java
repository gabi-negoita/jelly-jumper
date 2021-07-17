/*
    TEMPLATE METHOD PATTERN USED
 */
package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import model.MenuButton;
import model.ResetLevelButton;
import model.BackgroundImage1;
import controller.BlockFactory;
import controller.IBlock;
import controller.ILevelBackground;

public class Level1 extends ALevel {

    // <editor-fold defaultstate="collapsed" desc="--- VARIABLES ---">
    protected ILevelBackground background;

    protected ResetLevelButton resetButton;
    protected MenuButton menuButton;

    protected BlockFactory blockFactory;
    protected IBlock object;

    protected boolean levelAccomplished;
    protected boolean gameOver;
    // </editor-fold>

    public Level1() {
        super();
        
        playerInitialPosition = new Point(300, 100);
        background = new BackgroundImage1();

        super.createPlayer(playerInitialPosition);
        createMap();

        blockFactory = new BlockFactory();
        resetButton = ResetLevelButton.getInstance();
        menuButton = MenuButton.getInstance();

        levelAccomplished = false;
        gameOver = false;

    }

    // <editor-fold defaultstate="collapsed" desc="--- METHODS ---">
    @Override
    protected void createMap() {
        blocks[2][3] = 1;
        blocks[2][4] = 1;
        blocks[2][5] = 1;
        blocks[4][4] = 1;
        blocks[4][5] = 1;
        blocks[4][6] = 1;
        blocks[6][3] = 1;
    }

    @Override
    protected void resetLevel() {
        System.out.println("RESETTING LEVEL ... ");

        super.createPlayer(playerInitialPosition);
        createMap();
        levelAccomplished = false;
        gameOver = false;
        repaint();
    }

    @Override
    protected void levelAccomplished() {
        levelAccomplished = true; 
        repaint();
    }

    @Override
    protected void gameOver() {
        if (!levelAccomplished) {
            gameOver = true;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Rendering the background
        g.drawImage(background.getBackgroundImage(), 0, 0, this);

        // Rendering the reset and menu buttons
        g.drawImage(resetButton.getButtonIcon(), resetButton.getX(), resetButton.getY(), this);
        g.drawImage(menuButton.getButtonIcon(), menuButton.getX(), menuButton.getY(), this);

        if (gameOver) {
            // Showing the game over message
            int size = 100;
            g.setFont(new Font("TimesRoman", Font.BOLD, 36));
            g.setColor(Color.white);
            g.drawString("GAME OVER!", this.getBounds().width / 2 - 115, this.getBounds().height / 2 - 2);

            g.setColor(Color.darkGray);
            g.drawString("GAME OVER!", this.getBounds().width / 2 - 115, this.getBounds().height / 2 + 2);

            g.setColor(Color.red);
            g.drawString("GAME OVER!", this.getBounds().width / 2 - 115, this.getBounds().height / 2);
        } else if (levelAccomplished) {
            // Showing the winning message
            int size = 100;

            g.setFont(new Font("TimesRoman", Font.BOLD, 36));
            g.setColor(Color.red);
            g.drawString("WINNER!", this.getBounds().width / 2 - 70 - 1, this.getBounds().height / 2 - 1);

            g.setColor(Color.green);
            g.drawString("WINNER!", this.getBounds().width / 2 - 70 + 1, this.getBounds().height / 2 + 1);

            g.setColor(Color.white);
            g.drawString("WINNER!", this.getBounds().width / 2 - 70, this.getBounds().height / 2);
        } else {
            // Rendering the map
            for (int i = 0; i < blocks[0].length; i++) {
                for (int j = 0; j < blocks.length; j++) {
                    if (blocks[j][i] != 0) {
                        object = blockFactory.getBlock(blocks[j][i]);
                        g.drawImage(object.getBlockIcon(), i * 100, j * 100, this);
                    }
                }
            }

            // Rendering the player
            g.drawImage(player.getPlayerIcon(), player.getPosition().x, player.getPosition().y, this);
        }
    }

    // </editor-fold>
}
