/*
    FACTORY PATTERN USED
 */
package controller;

import model.BlockType2;
import model.BlockType1;

public class BlockFactory {

    public IBlock getBlock(int type) {
        IBlock object = null;

        switch (type) { 
            case 1:
                object = new BlockType1();
                break;
            case 2:
                object = new BlockType2();
                break;
            default:
                return null;
        }

        return object;
    }
}
