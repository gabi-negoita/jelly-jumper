/*
    FACTORY PATTERN USED
 */
package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import controller.IBlock;

public class BlockType1 extends Rectangle implements IBlock {

    private BufferedImage blockIcon;
 
    public BlockType1() {
        super();

        try {
            blockIcon = ImageIO.read(getClass().getResourceAsStream("/Images/type1brick-100x100.png"));
        } catch (IOException e) {
			System.out.println("ERROR: Reading background image from BlockType_1");
        }
    }

    @Override
    public BufferedImage getBlockIcon() {
        return this.blockIcon;
    }
}
