/*
    COMMAND PATTERN USED
 */
package controller; 

public class ButtonController {

    public static IElectronicButton getButton() {
        return new ElectronicButton();
    }
}
