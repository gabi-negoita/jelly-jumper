/*
    DECORATOR PATTERN USED
 */
package model;

import java.awt.image.BufferedImage; 
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class BackgroundImage1 extends ABackground {

    private BufferedImage background;

    public BackgroundImage1() {
        super();

        try {
            background = ImageIO.read(getClass().getResourceAsStream("/Images/image1-1000x1000.png"));
        } catch (IOException ex) {
            Logger.getLogger(BackgroundImage1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public BufferedImage getBackgroundImage() {
        return this.background;
    }
}
