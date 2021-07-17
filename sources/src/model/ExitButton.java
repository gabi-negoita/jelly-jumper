package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ExitButton {

    private int x = 925;
    private int y = 25;
    private int size = 50;
    private BufferedImage image;

    private static ExitButton button;

    private ExitButton() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Images/exit-50x50.png"));
        } catch (IOException e) {
            System.out.println("ERROR: Reading background image from ExitButton");
        }
    }

    public static ExitButton getInstance() {
        if (button == null) {
            button = new ExitButton();
        }
        return button;
    }

    public BufferedImage getButtonIcon() {
        return this.image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getSize() {
        return this.size;
    }

}
