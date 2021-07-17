/*
    COMMAND PATTERN USED
 */
package controller;
 
import javax.swing.JPanel;

public class GoToLevel2 implements ICommand {

    private IElectronicButton goToLevel2Button;

    public GoToLevel2(IElectronicButton goToLevel2Button) {
        this.goToLevel2Button = goToLevel2Button;
    }

    @Override
    public void execute(JPanel panel) {
        goToLevel2Button.goToLevel2(panel);
    }
}
