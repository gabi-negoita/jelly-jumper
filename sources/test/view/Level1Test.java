package view;

import java.awt.Point;
import java.awt.event.MouseEvent;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class Level1Test {

    Level1 level = null;

    Point playerInitialPosition;
    Point playerCurrentPosition;

    int[][] initialBlocks = null;
    int[][] currentBlocks = null;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        level = new Level1();
        playerInitialPosition = level.playerInitialPosition;
        initialBlocks = new int[level.blocks.length][level.blocks[0].length];

        for (int i = 0; i < initialBlocks.length; i++) {
            for (int j = 0; j < initialBlocks.length; j++) {
                initialBlocks[j][i] = level.blocks[j][i];
            }
        }
    }

    @After
    public void tearDown() {
        level = null;
        playerInitialPosition = null;
    }

    @Test
    public void testResetLevel() {
        System.out.println("Test Case: Resetting the level");
        // Jumping to another block
        level.jumpRight();

        // Player's position changed
        playerCurrentPosition = level.getPlayerCurrentPosition();

        // Map's matrix has changed
        currentBlocks = new int[level.blocks.length][level.blocks[0].length];
        for (int i = 0; i < currentBlocks.length; i++) {
            for (int j = 0; j < currentBlocks.length; j++) {
                currentBlocks[j][i] = level.blocks[j][i];
            }
        }

        // The player's position should be changeed
        assertNotEquals(playerInitialPosition, playerCurrentPosition);

        // The map's matrix should be changed
        boolean isDifferent = false;
        for (int i = 0; i < initialBlocks.length; i++) {
            for (int j = 0; j < initialBlocks[0].length; j++) {
                if (initialBlocks[i][j] != currentBlocks[i][j]) {
                    isDifferent = true;
                    break;
                }
            }
        }

        assertTrue(isDifferent);

        // Resetting the level
        level.resetLevel();

        // The player position should be the initial position
        playerCurrentPosition = level.player.getPosition();
        assertEquals(playerInitialPosition, playerCurrentPosition);

        // The map should be the initial map
        isDifferent = false;
        for (int i = 0; i < currentBlocks.length; i++) {
            for (int j = 0; j < currentBlocks.length; j++) {
                currentBlocks[j][i] = level.blocks[j][i];
            }
        }
        for (int i = 0; i < initialBlocks.length; i++) {
            for (int j = 0; j < initialBlocks[0].length; j++) {
                if (initialBlocks[i][j] != currentBlocks[i][j]) {
                    isDifferent = true;
                    break;
                }
            }
        }

        assertFalse(isDifferent);

    }

    @Test
    public void testGameOver() {
        System.out.println("Test Case: Losing the game");
        // The player's should not be changed
        playerCurrentPosition = level.player.getPosition();
        assertEquals(playerInitialPosition, playerCurrentPosition);

        // Initial variable's value should be false
        boolean currentGameOver = level.gameOver;
        assertFalse(currentGameOver);

        // Jumping left will result in throwing a IndexOutOfBoundsException exception
        // That is caught by calling the gameOver() method
        level.jumpLeft();

        // The variable's value should be true
        currentGameOver = level.gameOver;
        assertTrue(currentGameOver);

        // Resetting the level
        level.resetLevel();

        // The player should be in the initial position
        playerCurrentPosition = level.player.getPosition();
        assertEquals(playerInitialPosition, playerCurrentPosition);

        // Jumping four times to the right
        // The fourth time should make the player jump out the visible area
        // The game should be over after that
        level.jumpRight();
        // The player should be changed
        Point playerLastPosition = playerCurrentPosition;
        playerCurrentPosition = level.player.getPosition();
        assertNotEquals(playerLastPosition, playerCurrentPosition);
        // The game shouldn't be over
        assertFalse(level.gameOver);

        level.jumpRight();
        // The player should be changed
        playerLastPosition = playerCurrentPosition;
        playerCurrentPosition = level.player.getPosition();
        assertNotEquals(playerLastPosition, playerCurrentPosition);
        // The game shouldn't be over
        assertFalse(level.gameOver);

        level.jumpRight();
        // The player should be changed
        playerLastPosition = playerCurrentPosition;
        playerCurrentPosition = level.player.getPosition();
        assertNotEquals(playerLastPosition, playerCurrentPosition);
        // The game shouldn't be over
        assertFalse(level.gameOver);

        level.jumpRight();
        // The game should be over
        assertTrue(level.gameOver);

    }

    @Test
    public void testLevelAccomplished() {
        System.out.println("Test Case: Winning the game");

        MouseEvent mouseEvent = null;

        // The player's should not be changed
        playerCurrentPosition = level.player.getPosition();
        assertEquals(playerInitialPosition, playerCurrentPosition);

        // Initial variable's value should be false
        boolean currentGameWon = level.levelAccomplished;
        assertFalse(currentGameWon);

        // Jumping in such way that the player is going to win the game
        level.jumpRight();
        level.levelMouseReleased(mouseEvent);
        // The player should be changed
        Point playerLastPosition = playerCurrentPosition;
        playerCurrentPosition = level.player.getPosition();
        assertNotEquals(playerLastPosition, playerCurrentPosition);
        // The game shouldn't be won yet
        assertFalse(level.levelAccomplished);

        level.jumpRight();
        level.levelMouseReleased(mouseEvent);
        // The player should be changed
        playerLastPosition = playerCurrentPosition;
        playerCurrentPosition = level.player.getPosition();
        assertNotEquals(playerLastPosition, playerCurrentPosition);
        // The game shouldn't be won yet
        assertFalse(level.levelAccomplished);

        level.jumpRight();
        level.levelMouseReleased(mouseEvent);
        // The player should be changed
        playerLastPosition = playerCurrentPosition;
        playerCurrentPosition = level.player.getPosition();
        assertNotEquals(playerLastPosition, playerCurrentPosition);
        // The game shouldn't be won yet
        assertFalse(level.levelAccomplished);

        level.jumpLeft();
        // The player should be changed
        playerLastPosition = playerCurrentPosition;
        playerCurrentPosition = level.player.getPosition();
        assertNotEquals(playerLastPosition, playerCurrentPosition);
        // The game shouldn't be won yet
        assertFalse(level.levelAccomplished);

        level.jumpLeft();
        level.levelMouseReleased(mouseEvent);
        // The player should be changed
        playerLastPosition = playerCurrentPosition;
        playerCurrentPosition = level.player.getPosition();
        assertNotEquals(playerLastPosition, playerCurrentPosition);
        // The game shouldn't be won yet
        assertFalse(level.levelAccomplished);

        level.jumpLeft();
        level.levelMouseReleased(mouseEvent);
        // The player should be changed
        playerLastPosition = playerCurrentPosition;
        playerCurrentPosition = level.player.getPosition();
        assertNotEquals(playerLastPosition, playerCurrentPosition);
        // The game should be won
        assertTrue(level.levelAccomplished);

    }

}
