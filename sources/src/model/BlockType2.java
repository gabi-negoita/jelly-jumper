/*
    FACTORY PATTERN USED
 */
package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import controller.IBlock;

public class BlockType2 extends Rectangle implements IBlock {

    BufferedImage blockIcon;
 
    public BlockType2() {
        super();

        try {
            blockIcon = ImageIO.read(getClass().getResourceAsStream("/Images/type2brick-100x100.png"));
        } catch (IOException e) {
            System.out.println("ERROR: Reading background image from BlockType_2");
        }
    }

    @Override
    public BufferedImage getBlockIcon() {
        return this.blockIcon;
    }
}
