/*
    DECORATOR PATTERN USED
 */
package model;

import java.awt.image.BufferedImage; 
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackgroundImage2 extends ABackground {

    private BufferedImage background;

    public BackgroundImage2() {
        super();

        try {
            background = ImageIO.read(getClass().getResourceAsStream("/Images/image2-1000x1000.png"));
        } catch (IOException e) {
            System.out.println("ERROR: Reading background image from BackgroundImage2");
        }
    }

    @Override
    public BufferedImage getBackgroundImage() {
        return this.background;
    }

}
