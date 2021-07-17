/*
    COMMAND PATTERN USED
 */
package controller; 

import javax.swing.JPanel;

public class Button {

    private ICommand command;

    public Button(ICommand command) {
        this.command = command;
    }

    public void buttonPressed(JPanel panel) {
        command.execute(panel);
    }
}
