/*
    COMMAND PATTERN USED
 */
package controller; 

import javax.swing.JPanel;

public class GoToMenu implements ICommand {

    private IElectronicButton goToMenuButton;

    public GoToMenu(IElectronicButton goToMenuButton) {
        this.goToMenuButton = goToMenuButton;
    }

    @Override
    public void execute(JPanel panel) {
        goToMenuButton.goToMenu(panel);
    }
}
