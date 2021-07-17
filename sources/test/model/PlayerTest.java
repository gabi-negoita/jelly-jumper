package model;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

    public PlayerTest() {
    }

    @Test
    public void testGetInstance() {
        System.out.println("Test Case: Player objects should be singleton");

        // Creating a reference to Player class
        Player object1 = null;
        assertNull(object1);

        // Creating an instance of type Player
        object1 = Player.getInstance();
        assertNotNull(object1);

        // Creating another reference to Player class
        Player object2 = null;
        assertNull(object2);

        // Creating another instance of type Player
        object2 = Player.getInstance();
        assertNotNull(object2);

        // The two objects should be the same
        assertEquals(object1, object2);
    }
}
