/*
    COMMAND PATTERN USED
 */
package controller; 

import javax.swing.JPanel;

public class GoToLevel1 implements ICommand {

    private IElectronicButton goToLevel1Button;

    public GoToLevel1(IElectronicButton goToLevel1Button) {
        this.goToLevel1Button = goToLevel1Button;
    }

    @Override
    public void execute(JPanel panel) {
        goToLevel1Button.goToLevel1(panel);
    }
}
