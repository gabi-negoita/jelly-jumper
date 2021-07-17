package model;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen {

    public static int getWidth() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        return size.width;
    }

    public static int getHeight() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        return size.height;
    }
}
