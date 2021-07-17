/*
    DECORATOR PATTERN USED
 */
package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
 
public class BackgroundMenu extends ABackground {

    private BufferedImage background;

    public BackgroundMenu() {
        super();

        try {
            background = ImageIO.read(getClass().getResourceAsStream("/Images/menu-1000x1000.png"));
        } catch (IOException e) {
            System.out.println("ERROR: Reading background image from BackgroundMenu");
        }
    }

    @Override
    public BufferedImage getBackgroundImage() {
        return this.background;
    }
}
