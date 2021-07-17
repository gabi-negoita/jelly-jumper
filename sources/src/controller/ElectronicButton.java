/*
    COMMAND PATTERN USED
 */
package controller; 

import javax.swing.JPanel;
import view.Level1;
import view.Level2;
import view.Menu;

public class ElectronicButton implements IElectronicButton {

    public boolean resettingLevel = false;
    public boolean goingToMenu = false;

    @Override
    public void goToMenu(JPanel panel) {
        System.out.println("GOING TO MENU ... ");
        Main.frame.add(new Menu());
        Main.frame.remove(panel);
        Main.frame.validate();
    }

    @Override
    public void goToLevel1(JPanel panel) {
        System.out.println("GOING TO LEVEL 1 ... ");
        Main.frame.add(new Level1());
        Main.frame.remove(panel);
        Main.frame.validate();
    }

    @Override
    public void goToLevel2(JPanel panel) {
        System.out.println("GOING TO LEVEL 2 ... ");
        Main.frame.add(new Level2());
        Main.frame.remove(panel);
        Main.frame.validate();
    }

}
