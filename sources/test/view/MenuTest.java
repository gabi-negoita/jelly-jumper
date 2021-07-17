package view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MenuTest {

    Menu menu = null;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @After
    public void tearDown() {
        menu = null;
    }

    @Test
    public void testLevelMousePressed() {
        System.out.println("Test Case: Exiting the game");

        // Before pressing the exit button
        assertFalse("The exit menu doesn't work properly before pressing it", menu.exit);

        // After pressing the exit button
        menu.exit();
        assertTrue("The exit menu doesn't work properly after pressing it", menu.exit);
    }
}
