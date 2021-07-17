/*
    DECORATOR PATTERN USED
 */
package model;

import controller.ILevelBackground;
import java.awt.image.BufferedImage; 

public abstract class ABackground implements ILevelBackground {

    private ILevelBackground tempLevelBackground;

    @Override
    public BufferedImage getBackgroundImage() {
        return tempLevelBackground.getBackgroundImage();
    }
}
