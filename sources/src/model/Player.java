/*
    SINGLETON PATTERN USED
 */
package model;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player {

    private Point position;
    private BufferedImage playerIcon;
    private static Player player;

    private Player() {
        try {
            playerIcon = ImageIO.read(getClass().getResourceAsStream("/Images/mario-100x100.png"));
        } catch (IOException e) {
            System.out.println("ERROR: Reading background image from Player");
        }
    }

    public static Player getInstance() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    public BufferedImage getPlayerIcon() {
        return this.playerIcon;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return this.position;
    }
}
